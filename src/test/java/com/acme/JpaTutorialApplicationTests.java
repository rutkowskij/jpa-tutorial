package com.acme;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.order.customer.Customer;
import com.acme.order.customer.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JpaTutorialApplication.class)
public class JpaTutorialApplicationTests {

	@Autowired
	private CustomerRepository repository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void loadData() {
		Customer customer = new Customer();
		customer.setName("Name");
		customer.setAddress("Address");
		customer.setEmail("asda@dasda.pl");

		repository.save(customer);

	}

}
