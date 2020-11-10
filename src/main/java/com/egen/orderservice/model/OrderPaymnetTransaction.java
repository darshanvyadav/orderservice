package com.egen.orderservice.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
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
@ToString
@Table(name = "OrderPaymnetTransaction")
public class OrderPaymnetTransaction {

	@Id
	@GeneratedValue
	@JsonIgnore
	private UUID transactionId;
	
	@NotNull(message = "nameOnCard cannot be null")
	private String nameOnCard;
	
	@NotNull(message = "cardNumber cannot be null")
	private String cardNumber;
	
	@NotNull(message = "expiryDate cannot be null")
	private String expiryDate;
	
	@NotNull(message = "cvv cannot be null")
	private String cvv;
	
	@NotNull(message = "deductionAmount cannot be null")
	private Integer deductionAmount;
	
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_OrderID")
	@JsonIgnore
	private OrderDetails orderDetails;

}
