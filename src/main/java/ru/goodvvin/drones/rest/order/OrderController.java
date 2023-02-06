package ru.goodvvin.drones.rest.order;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.goodvvin.drones.data.order.Order;
import ru.goodvvin.drones.data.order.OrderService;

import java.util.List;

/**
 * Controller for operations with order
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

	private final OrderService orderService;

	/**
	 * Create order for delivery
	 *
	 * @return created order
	 */
	@PostMapping
	public ResponseEntity<Order> createOrder(@RequestBody CreateOrderDTO order) {
		return ResponseEntity.ok(orderService.createOrder(order));
	}

	/**
	 * Get order list
	 * @param pageable paging parameters
	 * @return list of orders
	 */
	public ResponseEntity<List<Order>> getOrders(final Pageable pageable) {
		return ResponseEntity.ok(orderService.getOrderList(pageable));
	}
}
