package com.egen.orderservice.dto;

import java.util.List;
import java.util.UUID;

import com.egen.orderservice.model.OrderItemDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListOfOrders {
	
	private UUID orderId;
	
	private String Date;
	
	private String ShippingName;
	
	private  String OrderStatus;
	
	private List<OrderItemDetails> listOfItems;
	
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
