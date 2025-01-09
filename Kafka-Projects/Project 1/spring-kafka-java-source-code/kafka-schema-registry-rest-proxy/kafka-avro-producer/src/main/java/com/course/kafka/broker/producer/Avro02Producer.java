package com.course.kafka.broker.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.course.avro.data.Avro02;

@Service
public class Avro02Producer {

	@Autowired
	private KafkaTemplate<String, Avro02> kafkaTemplate;
	
	public void send(Avro02 data) {
		kafkaTemplate.send("sc-avro02", data);
	}
	
}
