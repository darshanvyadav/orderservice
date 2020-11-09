package com.egen.orderservice.dto;

import java.util.Set;
import java.util.UUID;

import com.egen.orderservice.model.OrderBillingAddress;
import com.egen.orderservice.model.OrderItemDetails;
import com.egen.orderservice.model.OrderPaymentDetails;
import com.egen.orderservice.model.OrderPaymnetTransaction;
import com.egen.orderservice.model.OrderShippingAddress;
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
	
	private Set<OrderPaymnetTransaction> orderPaymnetTransaction ;
	
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