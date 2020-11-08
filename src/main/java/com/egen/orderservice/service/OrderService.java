package com.egen.orderservice.service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egen.orderservice.model.OrderDetails;
import com.egen.orderservice.model.OrderItemDetails;
import com.egen.orderservice.model.OrderPaymentDetails;
import com.egen.orderservice.model.OrderPaymnetTransaction;
import com.egen.orderservice.model.OrderRequest;
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
		OrderDetails orderResponse = orderDetailsRepository.save(orderDetails);

		//orderResponse = saveItemList(createorder, orderResponse);

		//return savePaymentDetails(createorder, orderResponse);
		return orderResponse;
	}

	private OrderDetails saveItemList(OrderRequest createorder, OrderDetails orderResponse) {
		Set<OrderItemDetails> itemresponse = new HashSet<OrderItemDetails>();
		createorder.getItems().forEach(item -> {
			//item.setOrderDetails(orderResponse);
			OrderItemDetails itemResponse = orderItemDetailsRepository.save(item);
			itemresponse.add(itemResponse);
		});
		//orderResponse.setItems(itemresponse);
		return orderResponse;
	}

	private OrderDetails savePaymentDetails(OrderRequest createorder, OrderDetails orderResponse) {
		OrderPaymentDetails orderPaymentDetails = createorder.getOrderPaymentDetails();
		orderPaymentDetails.setOrderDetails(orderResponse);
		OrderPaymentDetails paymentresponse = orderPaymentDetailsRepository.save(orderPaymentDetails);
		Set<OrderPaymnetTransaction> paymnetTransactionResponse = new HashSet<OrderPaymnetTransaction>();
		Set<OrderPaymnetTransaction> orderPaymnetTransaction = createorder.getOrderPaymentDetails()
				.getOrderPaymnetTransaction();
		orderPaymnetTransaction.forEach(transaction -> {
			transaction.setOrderPaymentDetails(paymentresponse);
			paymnetTransactionResponse.add(orderPaymnetTransactionRepository.save(transaction));
		});
		paymentresponse.setOrderPaymnetTransaction(paymnetTransactionResponse);
		orderResponse.setOrderPaymentDetails(paymentresponse);
		return orderResponse;
	}

	public OrderRequest getOrderById(UUID orderID) {
		OrderDetails orderDetails = orderDetailsRepository.getOne(orderID);

		return null;
	}

}
