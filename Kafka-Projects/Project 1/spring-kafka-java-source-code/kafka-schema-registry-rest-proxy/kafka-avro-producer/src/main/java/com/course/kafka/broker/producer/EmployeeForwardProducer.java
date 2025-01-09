package com.course.kafka.broker.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.course.avro.data.EmployeeForward;

@Service
public class EmployeeForwardProducer {

	@Autowired
	private KafkaTemplate<String, EmployeeForward> kafkaTemplate;
	
	public void send(EmployeeForward data) {
		kafkaTemplate.send("sc-employee-forward", data);
	}
	
}
