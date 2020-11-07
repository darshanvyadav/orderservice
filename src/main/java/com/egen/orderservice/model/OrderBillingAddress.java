package com.egen.orderservice.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class OrderBillingAddress {
	
	@Id
	@GeneratedValue
	private UUID billing_address_id;
	
	private String billing_addressline1;
	
	private String billing_addressline2;
	
	private String billing_city;
	
	private String billing_state;
	
	private Integer billing_zip;
	
	@CreationTimestamp
	private LocalDateTime createTime;
	
	@UpdateTimestamp
	private LocalDateTime updatedTime;
	
	private String created_by = "java application";
	
	private String modified_by = "java application";
	
	@OneToMany(mappedBy = "orderBillingAddress")
	private List<OrderDetails> orderDetails ;

}
