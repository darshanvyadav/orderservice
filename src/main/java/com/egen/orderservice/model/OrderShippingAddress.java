package com.egen.orderservice.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "OrderShippingAddress")
public class OrderShippingAddress {

	@Id
	@GeneratedValue
	@JsonIgnore
	private UUID ShippingAddressId;
	
	@NotNull(message = "billingAddressName cannot be null")
	private String ShippingAddressName;
	
	@NotNull(message = "billingAddressName cannot be null")
	private String shippingAddressLine1;
	
	private String shippingAddressLine2;
	
	@NotNull(message = "billingAddressName cannot be null")
	private String shippingCity;
	
	@NotNull(message = "billingAddressName cannot be null")
	private String shippingState;
	
	@NotNull(message = "shippingZip cannot be null")
	@Size(max = 5, min = 5, message = "Shipping zip is not valid")
	private Integer shippingZip;
	
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
	
	/*
	 * @OneToMany(mappedBy = "orderShippingAddress") private List<OrderDetails>
	 * orderDetails ;
	 */
	

}
