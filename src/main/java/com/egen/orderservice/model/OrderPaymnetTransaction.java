package com.egen.orderservice.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class OrderPaymnetTransaction {

	@Id
	@GeneratedValue
	private UUID transaction_id;
	
	private String name_on_card;
	
	private String card_number;
	
	private LocalDate expiry_date;
	
	private String cvv;
	
	private Integer deduction_amount;
	
	@CreationTimestamp
	private LocalDateTime createTime;
	
	@UpdateTimestamp
	private LocalDateTime updatedTime;
	
	private String created_by = "java application";
	
	private String modified_by = "java application";
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_id", insertable = false, updatable = false )
	private OrderPaymentDetails orderPaymentDetails;

}
