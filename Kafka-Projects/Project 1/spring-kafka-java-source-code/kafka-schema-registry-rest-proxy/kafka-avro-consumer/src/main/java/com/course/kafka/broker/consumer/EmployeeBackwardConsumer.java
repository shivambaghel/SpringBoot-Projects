package com.course.kafka.broker.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.course.avro.data.EmployeeBackward;

@Service
public class EmployeeBackwardConsumer {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeBackwardConsumer.class);

//	@KafkaListener(topics = "sc-employee-backward")
	public void listen(ConsumerRecord<String, EmployeeBackward> record) {
		LOG.info("{} : {}", record.key(), record.value());
	}

}
