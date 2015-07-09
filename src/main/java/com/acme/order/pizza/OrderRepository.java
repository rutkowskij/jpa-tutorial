package com.acme.order.pizza;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.acme.order.OrderStatus;

public interface OrderRepository extends JpaRepository<PizzaOrder, Long> {
	List<PizzaOrder> findByStatus(@Param("status") OrderStatus status);
}
