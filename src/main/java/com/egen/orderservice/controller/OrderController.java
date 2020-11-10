package com.egen.orderservice.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
@Api(value = "Order Management System", description = "Operations Related to Orders in e-commers website")
@RequestMapping("/api")
public class OrderController {
	
	Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	public static final String lOG_MESSAGE = "Received Request for ";
	public static final String FETCHING = "fetching order with ";
	public static final String CREATING = "creating order";
	public static final String Updating = "updating order with order id ";
	public static final String CUSTOMER_ID = "Customer ID";
	public static final String ORDER_ID = "ORDER_ID";
	public static final String ITEMS = ", Number Of items : ";
	public static final String SHIPPING_NAME = ", Shipping Name : ";
	public static final String ORDER_STAUTS = ", Order Status ";

	@Autowired
	private OrderServiceImpl orderService;

	@ApiOperation(value = "Create Order", response = OrderDetails.class, notes = "Validate and Create Order request if successfull returns created order ID ")
	@PostMapping("/create")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public ResponseEntity<OrderDetails> createOrder(
			@Valid @RequestBody @ApiParam(name = "OrderRequest", type = "OrderRequest", value = "Receive Valid Data Transfer Object", required = true) OrderRequest orderRequest) {
		logger.info(lOG_MESSAGE+ CREATING +CUSTOMER_ID +  orderRequest.getOrderCustomerId() + ORDER_STAUTS + orderRequest.getOrderStatus() +
				ITEMS + orderRequest.getItems().size() + SHIPPING_NAME+ orderRequest.getOrderShippingAddress().getShippingAddressName());
		OrderDetails orderResponse = orderService.createOrder(orderRequest);
		return ResponseEntity.ok(orderResponse);
	}

	@GetMapping(value = "/{orderID}")
	@ApiOperation(value = "Get Order by Id", response = OrderDetails.class, notes = "Fetch Order by Id and returns fetched order")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public ResponseEntity<OrderDetails> getOrderByID(
			@PathVariable @ApiParam(name = "orderID", type = "UUID", value = "Receives Order Id", required = true) UUID orderID) {
		logger.info(lOG_MESSAGE+ ORDER_ID + orderID);
		OrderDetails orderById = orderService.getOrderByID(orderID);
		return ResponseEntity.ok(orderById);
	}

	@ApiOperation(value = "Orders by Customer ID", response = List.class, notes = "Returns list of available Orders by customer Id ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/customer/{customerId}")
	public ResponseEntity<List<OrderDetails>> getOrdersByCustomer(
			@ApiParam(name = "CustomerId", type = "String", value = "Receives Customer Id of an Order", required = true) @PathVariable String customerId) {
		logger.info(lOG_MESSAGE+ FETCHING +CUSTOMER_ID + customerId);
		List<OrderDetails> ordersByCustomerID = orderService.getOrdersByCustomerID(customerId);
		return ResponseEntity.ok(ordersByCustomerID);
	}

	@PutMapping("/update")
	@ApiOperation(value = "Update Order By ID", response = List.class, notes = "Validate and Update requested order using order ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public ResponseEntity<OrderDetails> updateOrderDetails(
			@Valid @RequestBody @ApiParam(name = "orderDetails", type = "OrderDetails", value = "Receives valid Order details with Id", required = true) OrderDetails orderDetails) {
		logger.info(lOG_MESSAGE + Updating + orderDetails.getOrderId());
		OrderDetails updateOrder = orderService.updateOrder(orderDetails);
		return ResponseEntity.ok(updateOrder);
	}

}
