package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.controllers.CustomerController;
import com.example.demo.entity.Customer;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TestCustomerController {
	    @InjectMocks
	    CustomerController controller;
	     
	     
	     
	    @Test
	    public void testFindAll() 
	    {
	        // given
	        
	           Customer result = controller.getCustomerById(102);
	           
	 
	         
	        assertThat(result.getCustomerName())
	                        .isEqualTo("Shyam");
	         
	    }

}
