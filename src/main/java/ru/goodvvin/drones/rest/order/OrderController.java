package ru.goodvvin.drones.rest.order;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.goodvvin.drones.data.order.Order;
import ru.goodvvin.drones.data.order.OrderService;

/**
 * Controller for operations with order
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/orders")
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

}
