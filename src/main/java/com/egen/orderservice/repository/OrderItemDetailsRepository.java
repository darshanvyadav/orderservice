package com.egen.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egen.orderservice.model.OrderItemDetails;

@Repository
public interface OrderItemDetailsRepository extends JpaRepository<OrderItemDetails, Long>{

}
