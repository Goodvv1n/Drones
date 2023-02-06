package ru.goodvvin.drones.data.order;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.goodvvin.drones.data.order.Order;

import java.util.List;

/**
 * Repository for operations with orders
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
