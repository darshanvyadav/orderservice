package com.egen.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egen.orderservice.model.OrderBillingAddress;

@Repository
public interface OrderBillingAddressRepository extends JpaRepository<OrderBillingAddress, Long>{

}
