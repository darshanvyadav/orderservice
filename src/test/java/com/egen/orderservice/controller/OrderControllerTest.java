package com.egen.orderservice.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.egen.orderservice.dto.OrderRequest;
import com.egen.orderservice.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = OrderController.class)
@SpringBootTest
public class OrderControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private OrderService orderService;
	
	@InjectMocks
	private OrderController OrderController;



	@Test
	public void shouldReturnUserCDSID() throws Exception {
		
		OrderRequest orderRequest = new OrderRequest();

	}

	//private OrderRequest


}
