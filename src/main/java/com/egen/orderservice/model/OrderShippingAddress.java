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
	private UUID shippingAddressId;

	@NotNull(message = "ShippingAddressName is null ")
	private String shippingAddressName;

	private String shippingAddressLine1;

	private String shippingAddressLine2;

	private String shippingCity;

	private String shippingState;

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
