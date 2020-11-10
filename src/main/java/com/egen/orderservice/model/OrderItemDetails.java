package com.egen.orderservice.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

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
public class OrderItemDetails {

	@Id
	@GeneratedValue
	@JsonIgnore
	private UUID itemId;

	@NotNull(message = "itemName cannot be null")
	private String itemName;
	
	@NotNull(message = "itemPrice cannot be null")
	private Float itemPrice;
	
	@NotNull(message = "itemDescription cannot be null")
	private String itemDescription;
	
	@JsonIgnore
	@CreationTimestamp
	private LocalDateTime createTime;
	
	@JsonIgnore
	@UpdateTimestamp
	private LocalDateTime updatedTime;
	
	@JsonIgnore
	private String createdBy = "java application";
	@JsonIgnore
	private String modifiedBy = "java application";
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_OrderID")
	@JsonIgnore
	private OrderDetails orderDetails;
	


}
