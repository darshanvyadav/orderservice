package com.egen.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egen.orderservice.model.OrderShippingAddress;

@Repository
public interface OrderShippingAddressRepository extends JpaRepository<OrderShippingAddress, Long>{

}
