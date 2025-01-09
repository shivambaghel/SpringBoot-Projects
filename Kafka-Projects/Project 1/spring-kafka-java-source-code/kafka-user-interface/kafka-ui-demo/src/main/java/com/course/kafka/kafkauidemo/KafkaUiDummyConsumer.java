package com.course.kafka.kafkauidemo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaUiDummyConsumer {

	private static final Logger LOG = LoggerFactory.getLogger(KafkaUiDummyConsumer.class);

	@KafkaListener(topics = "t-ui-demo-one", concurrency = "2")
	public void listenOne(ConsumerRecord<String, String> record) {
		LOG.info("{}", record.value());
	}

	@KafkaListener(topics = "t-ui-demo-two", concurrency = "1")
	public void listenTwo(ConsumerRecord<String, String> record) {
		LOG.info("{}", record.value());
	}

}
