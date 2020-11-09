package com.egen.orderservice.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "OrderPaymentDetails")
public class OrderPaymentDetails {

	@Id
	@GeneratedValue
	private UUID paymentId;
	
	private Integer subtotal;
	
	private Integer tax;
	
	private Integer total;
	
	private String paymentMethod;
	
	@CreatedDate
	private LocalDate paymentDate;
	
	@CreationTimestamp
	private LocalDateTime createTime;
	
	@UpdateTimestamp
	private LocalDateTime updatedTime;
	
	private String createdBy = "java application";
	
	private String modifiedBy = "java application";

//	@OneToOne()
//	@JoinColumn(name = "FK_oder_ID")
//	private OrderDetails OrderDetails;


}
