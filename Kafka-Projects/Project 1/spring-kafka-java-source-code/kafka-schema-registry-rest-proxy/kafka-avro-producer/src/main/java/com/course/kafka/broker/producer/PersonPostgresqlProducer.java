package com.course.kafka.broker.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.course.avro.data.PersonAddressPostgresql;

@Service
public class PersonPostgresqlProducer {

	@Autowired
	private KafkaTemplate<String, PersonAddressPostgresql> kafkaTemplate;
	
	public void publish(PersonAddressPostgresql data) {
		kafkaTemplate.send("sc-person-address-postgresql", data);
	}
	
}
