package com.course.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;

//@Service
public class HelloKafkaConsumer {

	@KafkaListener(topics = "t-hello")
	public void consume(String message) {
		System.out.println(message);
	}
	
}
