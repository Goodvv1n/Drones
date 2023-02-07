package ru.goodvvin.drones.rest.order;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.goodvvin.drones.data.order.Order;
import ru.goodvvin.drones.data.order.OrderService;

import java.util.List;

import static org.springframework.data.domain.Sort.Direction.DESC;

/**
 * Controller for operations with order
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/orders")
@Tag(name = "Order controller", description = "Order managing operations")
public class OrderController {

	private final OrderService orderService;

	/**
	 * Collect order for delivery
	 *
	 * @return created order
	 */
	@Operation(summary = "Collect order")
	@PostMapping
	public ResponseEntity<Order> createOrder(@RequestBody CreateOrderDTO order) {
		return ResponseEntity.ok(orderService.createOrder(order));
	}

	@Operation(summary = "Update order state")
	@PutMapping("/{id}")
	public ResponseEntity<Order> updateOrderState(@PathVariable Long id, @RequestBody UpdateOrderStateDTO dto) {
		return ResponseEntity.ok(orderService.updateOrderState(id, dto));
	}

	/**
	 * Get order list
	 * @param pageable paging parameters
	 * @return order list
	 */
	@Operation(summary = "Get order list")
	@GetMapping
	public ResponseEntity<List<Order>> getOrderList(@PageableDefault(sort = "id", direction = DESC) final Pageable pageable){
		return ResponseEntity.ok(orderService.getOrderList(pageable));
	}

	/**
	 * Get order by order identifier
	 * @param id order identifier
	 * @return order
	 */
	@Operation(summary = "Find order information")
	@GetMapping("/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		return ResponseEntity.ok(orderService.findById(id));
	}

	/**
	 * Get order by drone identifier
	 * @param droneId drone identifier
	 * @return order
	 */
	@Operation(summary = "Find order information by drone")
	@GetMapping("/drones/{droneId}")
	public ResponseEntity<Order> findByDroneId(@PathVariable Long droneId){
		return ResponseEntity.ok(orderService.findByDroneId(droneId));
	}
}
