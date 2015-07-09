package com.acme.order.pizza;

import java.util.Date;

import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.mongodb.core.mapping.Document;

import com.acme.order.OrderStatus;
import com.acme.order.customer.Customer;

@Data
@NoArgsConstructor
@Document
public class PizzaOrder {

	@Id
	private String id;
	private Customer customer;
	private PizzaType type;
	private OrderStatus status;
	private Date estimatedDeliveryTime;
	private Date finishTime;

	public PizzaOrder(Customer customer, PizzaType type) {
		this.status = OrderStatus.CREATED;
		this.customer = customer;
		this.type = type;
	}

	public void withEstimatedTime(Date date) {
		this.estimatedDeliveryTime = date;
	}

	public Date getEstimatedTime() {
		return estimatedDeliveryTime;
	}

	public void cancel() {
		this.status = OrderStatus.CANCELLED;
	}

	public boolean isCreated() {
		return this.status == OrderStatus.CREATED;
	}

	public boolean isCancelled() {
		return this.status == OrderStatus.CANCELLED;
	}

	public boolean isDelivered() {
		return this.status == OrderStatus.DELIVERED;
	}

	public String getEmail() {
		return customer.getEmail();
	}

	public String getAddress() {
		return customer.getAddress();
	}

	public void deliver() {
		this.status = OrderStatus.DELIVERED;
		finishTime = new Date();
	}

	public boolean wasDeliveredOnTime() {
		if (estimatedDeliveryTime == null) {
			return true;
		}
		if (status == OrderStatus.DELIVERED) {
			return estimatedDeliveryTime.after(finishTime);
		}
		throw new IllegalStateException("The Pizza is not delivered yet!");
	}

	public PizzaType getType() {
		return type;
	}

}
