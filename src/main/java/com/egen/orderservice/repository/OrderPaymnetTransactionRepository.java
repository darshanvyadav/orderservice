package com.egen.orderservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egen.orderservice.model.OrderPaymnetTransaction;

@Repository
public interface OrderPaymnetTransactionRepository extends JpaRepository<OrderPaymnetTransaction, UUID>{

}
