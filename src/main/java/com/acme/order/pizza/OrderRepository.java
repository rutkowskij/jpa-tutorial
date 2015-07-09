package com.acme.order.pizza;

import java.util.List;

import com.acme.order.OrderStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<PizzaOrder, String> {
	List<PizzaOrder> findByStatus(OrderStatus delivered);
}
