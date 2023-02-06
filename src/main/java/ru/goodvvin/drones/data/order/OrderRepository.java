package ru.goodvvin.drones.data.order;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.goodvvin.drones.data.order.Order;

/**
 * Repository for operations with orders
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
