package com.egen.orderservice.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "OrderBillingAddress")
public class OrderBillingAddress {

	@Id
	@GeneratedValue
	@JsonIgnore
	private UUID billingAddressId;

	@NotNull(message = "BillingAddressName is null ")
	private String billingAddressName;

	private String billingAddressLine1;

	private String billingAddressLine2;

	private String billingCity;

	private String billingState;

	private Integer billingZip;

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
	 * @OneToMany(mappedBy = "orderBillingAddress") private List<OrderDetails>
	 * orderDetails ;
	 */

}
