package com.egen.orderservice.service;

import java.util.List;
import java.util.UUID;

import com.egen.orderservice.dto.OrderRequest;
import com.egen.orderservice.model.OrderDetails;

public interface OrderService {
	
	public OrderDetails createOrder(OrderRequest createorder);
	
	public OrderDetails getOrderByID(UUID orderID);
	
	public List<OrderDetails> getOrdersByCustomerID(String customerId);

}
