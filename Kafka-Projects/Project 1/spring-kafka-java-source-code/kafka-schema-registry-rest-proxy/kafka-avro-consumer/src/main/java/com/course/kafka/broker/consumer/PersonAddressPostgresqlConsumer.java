package com.course.kafka.broker.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.course.avro.data.PersonAddressPostgresql;

@Service
public class PersonAddressPostgresqlConsumer {

	private static final Logger LOG = LoggerFactory.getLogger(PersonAddressPostgresqlConsumer.class);
	
	@KafkaListener(topics = "sc-person-address-postgresql")
	public void listen(ConsumerRecord<String, PersonAddressPostgresql> record) {
		LOG.info("{} : {}", record.key(), record.value());
	}
	
}
