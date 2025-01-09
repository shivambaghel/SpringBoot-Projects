package com.course.kafka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class JsonConfig {

	@Bean
	public ObjectMapper objectMapper() {
		var om = new ObjectMapper();
		om.findAndRegisterModules();
		
		return om;
	}
	
}
