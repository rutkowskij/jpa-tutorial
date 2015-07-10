package com.acme.order.customer;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Customer {
	@Id
	private String id;
	private String name;
	private String email;
	private String address;
	private CustomerType type;
}
