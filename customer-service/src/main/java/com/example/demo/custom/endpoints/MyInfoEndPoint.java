package com.example.demo.custom.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.*;
@Component
public class MyInfoEndPoint implements InfoContributor {
	


	@Autowired
	ConfigurableApplicationContext ctx;
	
	@Autowired
	Environment env;
	
	@Override
	public void contribute(Builder builder) {

		 int beanCount =ctx.getBeanDefinitionCount();
		 
	     Date  date=new Date(ctx.getStartupDate());
	     
	      HashMap<String, String> details = new HashMap<>();
	     
	      details.put("beanCount", Integer.toString(beanCount));
	      details.put("startUpdate", date.toString());
	      
	      
	      
	      details.put("os", env.getProperty("os.name"));
	}

}
