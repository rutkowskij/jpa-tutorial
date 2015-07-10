package com.acme;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.order.customer.Customer;
import com.acme.order.customer.CustomerRepository;
import com.acme.order.customer.CustomerType;
import com.acme.order.customer.CustomerTypeRepository;
import com.acme.order.pizza.PizzaOrderService;
import com.acme.order.pizza.PizzaType;
import com.google.common.collect.Lists;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JpaTutorialApplication.class)
public class JpaTutorialApplicationTests {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CustomerTypeRepository customerTypeRepository;
	@Autowired
	private PizzaOrderService pizzaOrderService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void dataLoads() {

		CustomerType customerType = CustomerType.builder()
												.name("INDIVIDUAL")
												.build();
		customerTypeRepository.save(customerType);

		Customer customer1 = new Customer(null, "John Smith", "john@smith.com", "Lodz, Jaracza 74", customerType);
		Customer customer2 = new Customer(null, "Jan Kowalski", "jan@kowalski.pl", "Lodz, Piotrkowska 100",
				customerType);
		customerRepository.save(Lists.newArrayList(customer1, customer2));

		pizzaOrderService.createOrder(customer1, PizzaType.BIG);
		pizzaOrderService.createOrder(customer1, PizzaType.NORMAL);
		pizzaOrderService.createOrder(customer1, PizzaType.SMALL);
		pizzaOrderService.createOrder(customer2, PizzaType.LARGE);
		pizzaOrderService.createOrder(customer2, PizzaType.NORMAL);
		pizzaOrderService.createOrder(customer2, PizzaType.NORMAL);

	}

}
