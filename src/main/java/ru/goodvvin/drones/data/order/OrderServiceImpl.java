package ru.goodvvin.drones.data.order;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.goodvvin.drones.data.ObjectNotFoundException;
import ru.goodvvin.drones.data.drone.Drone;
import ru.goodvvin.drones.data.drone.DroneService;
import ru.goodvvin.drones.data.drone.DroneState;
import ru.goodvvin.drones.data.medicine.MedicineRepository;
import ru.goodvvin.drones.rest.order.CreateOrderDTO;
import ru.goodvvin.drones.rest.order.CreateOrderItemDTO;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Implemention of service {@link OrderService}
 */
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;
	private final MedicineRepository medicineRepository;
	private final DroneService droneService;

	@Override
	@Transactional
	public Order createOrder(CreateOrderDTO createOrderDTO) {
		Order order = collectOrder(createOrderDTO);
		return orderRepository.save(order);
	}

	@Override
	public Order findById(Long orderId) {
		return orderRepository.findById(orderId)
			.orElseThrow(() -> new ObjectNotFoundException(Map.of("orderId", orderId), "Order with id did not found"));
	}

	@Override
	public Order findByDroneId(Long droneId) {
		return orderRepository.findByDroneId(droneId)
			.orElseThrow(() -> new ObjectNotFoundException(Map.of("droneId", droneId), "Order with drone identifier did not found"));
	}

	@Override
	public List<Order> getOrderList(Pageable pageable) {
		return orderRepository.findAll(pageable).getContent();
	}

	private OrderItem getOrderItem(CreateOrderItemDTO item) {
		return OrderItem.builder()
			.medicine(medicineRepository.findById(item.getMedicineId())
				.orElseThrow(() -> new ObjectNotFoundException(Map.of("medicineId", item.getMedicineId()), "Medicine with id did not found")))
			.count(item.getCount())
			.build();
	}

	private List<OrderItem> collectItems(List<CreateOrderItemDTO> items) {
		return items.stream().map(this::getOrderItem).collect(Collectors.toList());
	}

	private Drone findDrone(CreateOrderDTO orderDTO) {
		return droneService.getDrone(orderDTO.getDroneId());
	}

	private Integer calculateWeight(List<OrderItem> items) {
		int weight = 0;
		for (OrderItem item : items) {
			weight += item.getMedicine().getWeight() * item.getCount();
		}
		return weight;
	}

	private void validateDrone(Drone drone, int weight) {
		if (drone.getState() != DroneState.IDLE) {
			throw new OrderImpossibleException(Map.of(), "Drone is not available now");
		}
		if (drone.getBattery() < 25) {
			throw new OrderImpossibleException(Map.of("battery", drone.getBattery()), "Drone has low battery level");
		}
		if (drone.getWeightLimit() < weight) {
			throw new OrderImpossibleException(
				Map.of("order_weight", weight, "drone_weight_limit", drone.getWeightLimit()),
				"Drone has weight limit less than order weight");
		}
	}

	private Order collectOrder(CreateOrderDTO orderDTO) {
		List<OrderItem> items = collectItems(orderDTO.getItems());
		Drone drone = findDrone(orderDTO);

		validateDrone(drone, calculateWeight(items));
		drone = droneService.updateState(drone, DroneState.DELIVERING);

		return Order.builder()
			.items(items)
			.drone(drone)
			.build();
	}
}
