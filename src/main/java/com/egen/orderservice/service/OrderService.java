package com.egen.orderservice.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egen.orderservice.dto.OrderRequest;
import com.egen.orderservice.exception.OrderNotFoundException;
import com.egen.orderservice.model.OrderDetails;
import com.egen.orderservice.repository.OrderDetailsRepository;

@Service
public class OrderService {

	@Autowired
	OrderDetailsRepository orderDetailsRepository;

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

	public OrderDetails getOrderByID(UUID orderID) {

		Optional<OrderDetails> findById = orderDetailsRepository.findById(orderID);

		System.out.println(findById);

		if (findById.isPresent()) {
			return findById.get();
		} else {
			throw new OrderNotFoundException("Order not forund for Id " + orderID.toString());
		}
	}

	public List<OrderDetails> getOrdersByCustomerID(String customerId) {
		List<OrderDetails> findByOrderCustomerId = orderDetailsRepository.findByOrderCustomerId(customerId);
		System.out.println(findByOrderCustomerId.size());
		return findByOrderCustomerId;
	}

}
