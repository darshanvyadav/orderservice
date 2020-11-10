package com.egen.orderservice.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.egen.orderservice.dto.OrderRequest;
import com.egen.orderservice.model.OrderDetails;
import com.egen.orderservice.service.OrderServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController()
@Api(value="Order Management System", description="Operations Related to Orders in e-commers website")
public class OrderController {

	@Autowired
	private OrderServiceImpl orderService;

	@PostMapping("/create")
	public ResponseEntity<OrderDetails> createOrder(@Valid @RequestBody OrderRequest orderRequest) {
		OrderDetails orderResponse = orderService.createOrder(orderRequest);
		return ResponseEntity.ok(orderResponse);
	}

	@GetMapping(value = "/{orderID}")
	public OrderDetails getOrderByID(@PathVariable UUID orderID) {
		OrderDetails orderById = orderService.getOrderByID(orderID);
		return orderById;
	}

	@ApiOperation(value = "Orders by Customer ID", response = List.class, notes = "View list of available Orders by customer Id ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/customer/{customerId}")
	public List<OrderDetails> getOrdersByCustomer( @PathVariable String customerId ) {
		return orderService.getOrdersByCustomerID(customerId);
	}
	
	@PutMapping("update")
	public ResponseEntity<OrderDetails> updateOrderDetails(@Valid @RequestBody OrderDetails orderDetails) {
		OrderDetails updateOrder = orderService.updateOrder(orderDetails);
		return ResponseEntity.ok(updateOrder);
	}
	
	

}
