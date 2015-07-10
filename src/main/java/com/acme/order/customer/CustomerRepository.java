package com.acme.order.customer;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends MongoRepository<Customer, String> {

	List<Customer> findByName(@Param("name") String name);

	List<Customer> findByEmail(@Param("email") String email);
}
