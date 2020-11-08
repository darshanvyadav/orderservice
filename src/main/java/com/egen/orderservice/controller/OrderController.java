package com.egen.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.egen.orderservice.model.OrderDetails;
import com.egen.orderservice.model.OrderRequest;
import com.egen.orderservice.service.OrderService;

@CrossOrigin()
@RestController()
public class OrderController {
	
	
	@Autowired
	private OrderService orderService;

	@PostMapping(value = "createorder")
	public OrderDetails createOrder(@RequestBody OrderRequest orderRequest) {
		OrderDetails createdOrder = orderService.createOrder(orderRequest);
		return createdOrder;
	}
	
	@GetMapping(value = "/orderById/{orderID}")
	public OrderRequest getOrderByID(@RequestBody OrderRequest orderRequest) {
		OrderDetails createdOrder = orderService.createOrder(orderRequest);
		return null;
	}
	
	@GetMapping(value = "/ordersbycustomer/{customerId}")
	public List<OrderDetails> getOrdersByCustomer(@RequestBody OrderRequest orderRequest) {
		OrderDetails createdOrder = orderService.createOrder(orderRequest);
		return null;
	}
	
	
}
