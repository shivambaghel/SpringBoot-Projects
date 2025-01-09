package com.course.kafka.broker.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.course.avro.data.Avro01;

@Service
public class Avro01Producer {

	@Autowired
	private KafkaTemplate<String, Avro01> kafkaTemplate;
	
	public void send(Avro01 data) {
		kafkaTemplate.send("sc-avro01", data);
	}
	
}
