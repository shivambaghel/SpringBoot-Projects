package com.course.kafka.scheduler;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.course.avro.data.EmployeeForward;
import com.course.kafka.broker.producer.EmployeeForwardProducer;

@Service
public class EmployeeForwardScheduler {

	@Autowired
	private EmployeeForwardProducer producer;

	@Scheduled(fixedRate = 1000)
	public void publish() {
		var now = LocalTime.now();
		var data = EmployeeForward.newBuilder().setFirstName("First name " + now).setLastName("Last name " + now)
				.setEmail("Email " + now)
				.build();

		producer.send(data);
	}

}
