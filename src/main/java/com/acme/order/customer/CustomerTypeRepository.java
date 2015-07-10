package com.acme.order.customer;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerTypeRepository extends MongoRepository<CustomerType, String> {
}
