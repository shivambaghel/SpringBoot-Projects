package com.course.kafka.broker.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.course.avro.data.Avro01;

@Service
public class Avro01Consumer {

	private static final Logger LOG = LoggerFactory.getLogger(Avro01Consumer.class);

//	@KafkaListener(topics = "sc-avro01")
	public void listen(ConsumerRecord<String, Avro01> record) {
		LOG.info("{} : {}", record.key(), record.value());
	}

}
