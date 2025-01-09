package com.course.kafka.broker.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.course.avro.data.Avro02;

@Service
public class Avro02Consumer {

	private static final Logger LOG = LoggerFactory.getLogger(Avro02Consumer.class);

//	@KafkaListener(topics = "sc-avro02")
	public void listen(ConsumerRecord<String, Avro02> record) {
		LOG.info("{} : {}", record.key(), record.value());
	}

}
