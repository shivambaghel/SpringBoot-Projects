package com.course.kafka.producer;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;

//@Service
public class FixedRate2Producer {

	private static final Logger LOG = LoggerFactory.getLogger(FixedRate2Producer.class);
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	private AtomicInteger counter = new AtomicInteger();
	
	@Scheduled(fixedRate = 1000)
	public void sendMessage() {
		var i = counter.incrementAndGet();
		LOG.info("i is " + i);
		kafkaTemplate.send("t-fixedrate-2", "Fixed rate " + i);
	}
	
}
