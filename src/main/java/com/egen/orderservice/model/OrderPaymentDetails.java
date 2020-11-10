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
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

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
@Table(name = "OrderPaymentDetails")
public class OrderPaymentDetails {

	@Id
	@GeneratedValue
	@JsonIgnore
	private UUID paymentId;
	
	@NotNull(message = "subtotal cannot be null")
	private Integer subtotal;
	
	@NotNull(message = "tax cannot be null")
	private Integer tax;
	
	@NotNull(message = "total cannot be null")
	private Integer total;
	
	@NotNull(message = "paymentMethod cannot be null")
	private String paymentMethod;
	
	@CreatedDate
	@JsonIgnore
	private LocalDate paymentDate;
	
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

//	@OneToOne()
//	@JoinColumn(name = "FK_oder_ID")
//	private OrderDetails OrderDetails;


}
