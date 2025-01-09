package com.course.kafka.kafkauidemo;

import java.time.LocalTime;
import java.util.ArrayList;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

@Service
public class KafkaUiDummyProducer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	private Faker faker = Faker.instance();

	@Autowired
	private ObjectMapper objectMapper;

	@Scheduled(fixedDelay = 2000)
	public void publishOne() {
		var now = LocalTime.now();
		var headers = new ArrayList<Header>();

		headers.add(new RecordHeader("Header key 1", Integer.toString(faker.random().nextInt(999999)).getBytes()));
		headers.add(new RecordHeader("Header key 2", Boolean.toString(faker.random().nextBoolean()).getBytes()));

		var record = new ProducerRecord<String, String>("t-ui-demo-one", null, "This key generated at " + now,
				"This dummy message value generated at " + now + " with boolean " + faker.random().nextBoolean(),
				headers);

		kafkaTemplate.send(record);
	}

	@Scheduled(fixedDelay = 2000)
	public void publishTwo() throws JsonProcessingException {
		var headers = new ArrayList<Header>();

		headers.add(new RecordHeader("country", faker.address().country().getBytes()));
		headers.add(new RecordHeader("version", faker.app().version().getBytes()));

		var person = new PersonMessage(faker.name().fullName(), faker.address().fullAddress());

		var record = new ProducerRecord<String, String>("t-ui-demo-two", null,
				"Random IP : " + faker.internet().ipV4Address(), objectMapper.writeValueAsString(person), headers);

		kafkaTemplate.send(record);
	}

}
