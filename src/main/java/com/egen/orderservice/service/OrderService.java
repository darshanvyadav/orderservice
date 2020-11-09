package com.egen.orderservice.service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egen.orderservice.dto.OrderRequest;
import com.egen.orderservice.model.OrderDetails;
import com.egen.orderservice.model.OrderItemDetails;
import com.egen.orderservice.model.OrderPaymentDetails;
import com.egen.orderservice.model.OrderPaymnetTransaction;
import com.egen.orderservice.repository.OrderDetailsRepository;
import com.egen.orderservice.repository.OrderItemDetailsRepository;
import com.egen.orderservice.repository.OrderPaymentDetailsRepository;
import com.egen.orderservice.repository.OrderPaymnetTransactionRepository;

@Service
public class OrderService {

	@Autowired
	OrderDetailsRepository orderDetailsRepository;

	@Autowired
	OrderItemDetailsRepository orderItemDetailsRepository;

	@Autowired
	OrderPaymentDetailsRepository orderPaymentDetailsRepository;

	@Autowired
	OrderPaymnetTransactionRepository orderPaymnetTransactionRepository;

	public OrderDetails createOrder(OrderRequest createorder) {

		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setItems(createorder.getItems());
		orderDetails.setOrderBillingAddress(createorder.getOrderBillingAddress());
		orderDetails.setOrderShippingAddress(createorder.getOrderShippingAddress());
		orderDetails.setOrderStatus(createorder.getOrderStatus());
		orderDetails.setOrderCustomerId(createorder.getOrderCustomerId());
		orderDetails.setShippingMethod(createorder.getShippingMethod());
		orderDetails.setOrderPaymentDetails(createorder.getOrderPaymentDetails());
		orderDetails.setOrderPaymnetTransaction(createorder.getOrderPaymnetTransaction());
		OrderDetails orderResponse = orderDetailsRepository.save(orderDetails);
		return orderResponse;
	}

}
