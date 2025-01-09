package com.course.kafka.broker.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.course.avro.data.Hello;

@Service
public class HelloProducer {

	@Autowired
	private KafkaTemplate<String, Hello> kafkaTemplate;
	
	public void send(Hello data) {
		kafkaTemplate.send("sc-hello", data);
	}
	
}
