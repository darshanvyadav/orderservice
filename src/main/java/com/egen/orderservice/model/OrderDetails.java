package com.egen.orderservice.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDetails {

	@Id
	@GeneratedValue
	private UUID order_id;
	
	private String order_status;
	
	private Long order_customer_id;
	
	private String shipping_method;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "orderDetails")
	private List<OrderItemDetails> items = new ArrayList<OrderItemDetails>();
	
	@OneToOne(mappedBy = "orderDetails", cascade = CascadeType.ALL)
    private OrderPaymentDetails orderPaymentDetails;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "billing_address_id")
	private OrderBillingAddress orderBillingAddress;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "Shipping_address_id")
	private OrderShippingAddress orderShippingAddress;
	
	@CreationTimestamp
	private LocalDateTime createTime;
	
	@UpdateTimestamp
	private LocalDateTime updatedTime;
	
	private String created_by = "java application";
	
	private String modified_by = "java application";
	
}
