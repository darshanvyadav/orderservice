package com.egen.orderservice.dto;

import com.egen.orderservice.model.OrderBillingAddress;
import com.egen.orderservice.model.OrderItemDetails;
import com.egen.orderservice.model.OrderPaymentDetails;
import com.egen.orderservice.model.OrderShippingAddress;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OrderRequest {
	
	private OrderItemDetails OrderItemDetails;
	
	private OrderPaymentDetails orderPaymentDetails;
	
	private OrderShippingAddress orderShippingAddress;
	
	private OrderBillingAddress orderBillingAddress;
	
	@Override
	public String toString() {
	      ObjectMapper mapper = new ObjectMapper();
	      try {
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "error converting object in to string";
		}
	}

}
