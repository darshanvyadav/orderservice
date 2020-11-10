package com.egen.orderservice.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

	@NotNull(message = "billingAddressName cannot be null")
	private String billingAddressName;

	@NotNull(message = "billingAddressLine1 cannot be null")
	private String billingAddressLine1;

	private String billingAddressLine2;

	@NotNull(message = "billingCity cannot be null")
	private String billingCity;

	@NotNull(message = "billingState cannot be null")
	private String billingState;

	@Size(max = 5, min = 5, message = "not a valid zip")
	@NotNull(message = "billing zip is not valid")
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
