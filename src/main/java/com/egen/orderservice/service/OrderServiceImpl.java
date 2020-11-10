package com.egen.orderservice.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egen.orderservice.dto.OrderRequest;
import com.egen.orderservice.exception.OrderNotFoundException;
import com.egen.orderservice.model.OrderDetails;
import com.egen.orderservice.model.OrderItemDetails;
import com.egen.orderservice.model.OrderPaymnetTransaction;
import com.egen.orderservice.repository.OrderDetailsRepository;
import com.egen.orderservice.repository.OrderItemDetailsRepository;
import com.egen.orderservice.repository.OrderPaymnetTransactionRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDetailsRepository orderDetailsRepository;

	@Autowired
	OrderItemDetailsRepository OrderItemDetailsRepository;

	@Autowired
	OrderPaymnetTransactionRepository orderPaymnetTransactionRepository;

	@Transactional
	@Override
	public OrderDetails createOrder(OrderRequest createorder) {

		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setOrderBillingAddress(createorder.getOrderBillingAddress());
		orderDetails.setOrderShippingAddress(createorder.getOrderShippingAddress());
		orderDetails.setOrderStatus(createorder.getOrderStatus());
		orderDetails.setOrderCustomerId(createorder.getOrderCustomerId());
		orderDetails.setShippingMethod(createorder.getShippingMethod());
		orderDetails.setOrderPaymentDetails(createorder.getOrderPaymentDetails());
		OrderDetails orderResponse = orderDetailsRepository.save(orderDetails);
		
		createorder.getItems().forEach(item -> item.setOrderDetails(orderResponse));
		List<OrderItemDetails> itemResponse = OrderItemDetailsRepository.saveAll(createorder.getItems());
		
		createorder.getOrderPaymnetTransaction().forEach(transaction -> transaction.setOrderDetails(orderDetails));
		List<OrderPaymnetTransaction> transactionsResponse = orderPaymnetTransactionRepository
				.saveAll(createorder.getOrderPaymnetTransaction());
		
		orderDetails.setItems(itemResponse);
		orderDetails.setOrderPaymnetTransaction(transactionsResponse);
		
		return orderResponse;
	}

	@Transactional
	@Override
	public OrderDetails getOrderByID(UUID orderID) {

		Optional<OrderDetails> findById = orderDetailsRepository.findById(orderID);

		System.out.println(findById);

		if (findById.isPresent()) {
			return findById.get();
		} else {
			throw new OrderNotFoundException("Order not forund for Id " + orderID.toString());
		}
	}

	@Transactional
	@Override
	public List<OrderDetails> getOrdersByCustomerID(String customerId) {
		return orderDetailsRepository.findAllByOrderCustomerId(customerId);
		// return null;
	}

	@Override
	public OrderDetails updateOrder(OrderDetails orderDetails) {
		return orderDetailsRepository.save(orderDetails);
	}

}
