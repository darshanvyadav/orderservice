package com.egen.orderservice.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egen.orderservice.dto.OrderRequest;
import com.egen.orderservice.exception.OrderCreateException;
import com.egen.orderservice.exception.OrderNotFoundException;
import com.egen.orderservice.model.OrderDetails;
import com.egen.orderservice.model.OrderItemDetails;
import com.egen.orderservice.model.OrderPaymnetTransaction;
import com.egen.orderservice.repository.OrderDetailsRepository;
import com.egen.orderservice.repository.OrderItemDetailsRepository;
import com.egen.orderservice.repository.OrderPaymnetTransactionRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	public static final String lOG_MESSAGE = "Received Request for ";
	public static final String FETCHING = "fetching order with ";
	public static final String CREATING = "creating order";
	public static final String Updating = "updating order with order id ";
	public static final String CUSTOMER_ID = "Customer ID";
	public static final String ORDER_ID = "ORDER_ID";
	public static final String ITEMS = ", Number Of items : ";
	public static final String SHIPPING_NAME = ", Shipping Name : ";
	public static final String ORDER_STAUTS = ", Order Status ";
	public static final String EXCEPTION = ", Exception occoured for ";
	public static final String BECAUSE = "Bacause of ";  
	public static final String ORDER_NOT_FOUND = "Order not forund for Id";
	@Autowired
	OrderDetailsRepository orderDetailsRepository;

	@Autowired
	OrderItemDetailsRepository OrderItemDetailsRepository;

	@Autowired
	OrderPaymnetTransactionRepository orderPaymnetTransactionRepository;

	@Override
	@Transactional
	public OrderDetails createOrder(OrderRequest createorder) {

		OrderDetails orderResponse;
		try {
			OrderDetails orderDetails = new OrderDetails();
			orderDetails.setOrderBillingAddress(createorder.getOrderBillingAddress());
			orderDetails.setOrderShippingAddress(createorder.getOrderShippingAddress());
			orderDetails.setOrderStatus(createorder.getOrderStatus());
			orderDetails.setOrderCustomerId(createorder.getOrderCustomerId());
			orderDetails.setShippingMethod(createorder.getShippingMethod());
			orderDetails.setOrderPaymentDetails(createorder.getOrderPaymentDetails());
			orderResponse = orderDetailsRepository.save(orderDetails);

			createorder.getItems().forEach(item -> item.setOrderDetails(orderResponse));
			List<OrderItemDetails> itemResponse = OrderItemDetailsRepository.saveAll(createorder.getItems());

			createorder.getOrderPaymnetTransaction().forEach(transaction -> transaction.setOrderDetails(orderDetails));
			List<OrderPaymnetTransaction> transactionsResponse = orderPaymnetTransactionRepository
					.saveAll(createorder.getOrderPaymnetTransaction());

			orderDetails.setItems(itemResponse);
			orderDetails.setOrderPaymnetTransaction(transactionsResponse);
		} catch (Exception e) {
			logger.error(EXCEPTION + CREATING +CUSTOMER_ID +  createorder.getOrderCustomerId() + ORDER_STAUTS + createorder.getOrderStatus() +
					ITEMS + createorder.getItems().size() + SHIPPING_NAME+ createorder.getOrderShippingAddress().getShippingAddressName()+
					BECAUSE + e.getMessage());
			throw new OrderCreateException(e.getMessage());
			
		}
		return orderResponse;
	}

	@Override
	public OrderDetails getOrderByID(UUID orderID) {
		try {
			Optional<OrderDetails> findById = orderDetailsRepository.findById(orderID);
			if (findById.isPresent()) {
				return findById.get();
			} else {
				logger.error(EXCEPTION + FETCHING + ORDER_ID + orderID + BECAUSE + ORDER_NOT_FOUND);
				throw new OrderNotFoundException(ORDER_NOT_FOUND + orderID.toString());
			}
		} catch (Exception e) {
			logger.error(EXCEPTION + FETCHING + ORDER_ID );
			throw e;
		}
		
	}

	@Override
	public List<OrderDetails> getOrdersByCustomerID(String customerId) {
		return orderDetailsRepository.findAllByOrderCustomerId(customerId);

	}

	@Override
	@Transactional
	public OrderDetails updateOrder(OrderDetails orderDetails) {
		return orderDetailsRepository.save(orderDetails);
	}

}
