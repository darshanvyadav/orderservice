package com.egen.orderservice.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
public class OrderPaymentDetails {

	@Id
	private UUID payment_id;
	
	private Integer subtotal;
	
	private Integer tax;
	
	private Integer total;
	
	private String payment_method;
	
	@CreatedDate
	private LocalDate payment_date;
	
	@CreationTimestamp
	private LocalDateTime createTime;
	
	@UpdateTimestamp
	private LocalDateTime updatedTime;
	
	private String created_by = "java application";
	
	private String modified_by = "java application";
	
    @OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", insertable = false, updatable = false)
	@MapsId
	private OrderDetails orderDetails;
	
	@OneToMany(mappedBy = "orderPaymentDetails", cascade = CascadeType.ALL)
	private List<OrderPaymnetTransaction> orderPaymnetTransaction ;

}
