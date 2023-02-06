package ru.goodvvin.drones.data.order;

import org.springframework.data.domain.Pageable;
import ru.goodvvin.drones.data.order.Order;
import ru.goodvvin.drones.rest.order.CreateOrderDTO;

import java.util.List;

/**
 * Interface of service for operations with orders
 */
public interface OrderService {

	/**
	 * Create order for delivering
	 * @param createOrderDTO order data
	 * @return created order information
	 */
	Order createOrder(CreateOrderDTO createOrderDTO);

	/**
	 * Find order by identifier
	 * @param orderId order identifier
	 * @return order
	 */
	Order findById(Long orderId);

	/**
	 * Find order by drone identifier
	 * @param droneId drone identifier
	 * @return order
	 */
	Order findByDroneId(Long droneId);

	/**
	 * Get order list
	 * @param pageable paging parameters
	 * @return order list
	 */
	List<Order> getOrderList(Pageable pageable);
}
