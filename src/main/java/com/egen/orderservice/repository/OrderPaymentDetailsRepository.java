package com.egen.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egen.orderservice.model.OrderPaymentDetails;

@Repository
public interface OrderPaymentDetailsRepository extends JpaRepository<OrderPaymentDetails, Long>{

}
