package com.egen.orderservice.model;

import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
	
	private UUID orderId;
	
	private String orderStatus;
	
	private String orderCustomerId;
	
	private Set<OrderItemDetails> items;
	
	private String shippingMethod;	 
	
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
