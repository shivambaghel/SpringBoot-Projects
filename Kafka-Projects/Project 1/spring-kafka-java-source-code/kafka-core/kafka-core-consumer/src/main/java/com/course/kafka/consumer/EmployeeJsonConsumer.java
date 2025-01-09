package com.course.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.course.kafka.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//@Service
public class EmployeeJsonConsumer {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeJsonConsumer.class);
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@KafkaListener(topics = "t-employee-2")
	public void listen(String message) throws JsonMappingException, JsonProcessingException {
		var employee = objectMapper.readValue(message, Employee.class);
		LOG.info("Employee is : {}", employee);
	}
	
}
