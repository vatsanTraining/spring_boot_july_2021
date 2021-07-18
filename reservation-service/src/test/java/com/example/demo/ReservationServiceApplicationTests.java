package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.controllers.CustomerController;
import com.example.demo.entity.Customer;
import com.example.demo.repo.CustomerRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)

class ReservationServiceApplicationTests {

    @Autowired
    CustomerController custController;
 
   
    @MockBean
    CustomerRepository repo;

	
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testCustomerFindById() throws Exception {
	//	mockMvc.perform(get("/customers/102")).andExpect(status().isOk());
			
		
        Optional<Customer> cust = Optional.ofNullable(new Customer(101,"Ram",484848));
        
        Mockito.when(repo.findById(101)).thenReturn(cust);

		mockMvc.perform(get("/customers/101")).andExpect(status().isOk())
				.andExpect(jsonPath("$.customerName").value("Shyam"));

}

}