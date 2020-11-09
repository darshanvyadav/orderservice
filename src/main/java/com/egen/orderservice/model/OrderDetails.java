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
	
	@JsonProperty("orderStatus")
	private String orderStatus;
	
	private String orderCustomerId;
	
	private String shippingMethod;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_Items_ID", referencedColumnName = "orderId")
	private Set<OrderItemDetails> items;
	
	@OneToOne( cascade = CascadeType.ALL)
	@JoinColumn(name = "paymentId")
    private OrderPaymentDetails orderPaymentDetails;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "billingAddressId")
	private OrderBillingAddress orderBillingAddress;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "ShippingAddressId")
	private OrderShippingAddress orderShippingAddress;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_Transaction_ID",  referencedColumnName = "orderId" )
	private Set<OrderPaymnetTransaction> orderPaymnetTransaction ;
	
	@CreationTimestamp
	private LocalDateTime createTime;
	
	@UpdateTimestamp
	private LocalDateTime updatedTime;
	
	private String createdBy = "java application";
	
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
