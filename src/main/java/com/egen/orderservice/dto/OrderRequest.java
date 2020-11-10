package com.egen.orderservice.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.validation.constraints.NotNull;

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
public class OrderRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private UUID orderId;

	@NotNull(message = "orderStatus is null")
	private String orderStatus;

	@NotNull(message = "CustomerId is null")
	private String orderCustomerId;

	@NotNull(message = "items is null")
	private List<OrderItemDetails> items;

	@NotNull(message = "shippingMethod is null")
	private String shippingMethod;

	@NotNull(message = "PaymentDetails is null")
	private OrderPaymentDetails orderPaymentDetails;

	@NotNull(message = "ShippingAddress is null")
	private OrderShippingAddress orderShippingAddress;

	@NotNull(message = "BillingAddress is null")
	private OrderBillingAddress orderBillingAddress;

	@NotNull(message = "PaymnetTransaction details is null")
	private Set<OrderPaymnetTransaction> orderPaymnetTransaction;

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