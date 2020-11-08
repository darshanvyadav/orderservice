package com.egen.orderservice.model;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	
	@JsonProperty("orderStatus")
	private String orderStatus;
	
	private String orderCustomerId;
	
	private String shippingMethod;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderId", referencedColumnName = "orderId")
	private Set<OrderItemDetails> items;
	
	@OneToOne(mappedBy = "orderDetails", cascade = CascadeType.ALL)
    private OrderPaymentDetails orderPaymentDetails;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "billingAddressId")
	private OrderBillingAddress orderBillingAddress;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ShippingAddressId")
	private OrderShippingAddress orderShippingAddress;
	
	@CreationTimestamp
	private LocalDateTime createTime;
	
	@UpdateTimestamp
	private LocalDateTime updatedTime;
	
	private String createdBy = "java application";
	
	private String modifiedBy = "java application";
	
	
	
}
