package com.egen.orderservice.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "OrderDetails")
public class OrderDetails {

	@Id
	@GeneratedValue
	private UUID orderId;

	@NotNull(message = "Order Status is null ")
	private String orderStatus;

	@NotNull(message = "Order customer id is null ")
	private String orderCustomerId;

	@NotNull(message = "Order Shipping method is null ")
	private String shippingMethod;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "orderDetails")
	@JsonIgnoreProperties("orderDetails")
	private List<OrderItemDetails> items;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "paymentId")
	private OrderPaymentDetails orderPaymentDetails;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "billingAddressId")
	private OrderBillingAddress orderBillingAddress;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ShippingAddressId")
	private OrderShippingAddress orderShippingAddress;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "orderDetails")
	@JsonIgnoreProperties("orderDetails")
	private List<OrderPaymnetTransaction> orderPaymnetTransaction;

	@CreationTimestamp
	@JsonIgnore
	private LocalDateTime createTime;

	@UpdateTimestamp
	@JsonIgnore
	private LocalDateTime updatedTime;

	@JsonIgnore
	private String createdBy = "java application";

	@JsonIgnore
	private String modifiedBy = "java application";

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
