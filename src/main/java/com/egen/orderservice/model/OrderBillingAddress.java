package com.egen.orderservice.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "OrderBillingAddress")
public class OrderBillingAddress {
	
	@Id
	@GeneratedValue
	private UUID billingAddressId;
	
	private String billingAddressLine1;
	
	private String billingAddressLine2;
	
	private String billingCity;
	
	private String billingState;
	
	private Integer billingZip;
	
	@CreationTimestamp
	private LocalDateTime createTime;
	
	@UpdateTimestamp
	private LocalDateTime updatedTime;
	
	private String createdBy = "java application";
	
	private String modifiedBy = "java application";
	
	@OneToMany(mappedBy = "orderBillingAddress")
	private List<OrderDetails> orderDetails ;
	


}
