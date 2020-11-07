package com.egen.orderservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.egen.orderservice.dto.OrderRequest;

@RestController
public class OrderController {

	
	@PostMapping(value = "/order/create")
	public String orderController(@RequestBody OrderRequest orderRequest) {
		
		
		System.out.println(orderRequest.toString());
		
		return "Test";
	}
}
