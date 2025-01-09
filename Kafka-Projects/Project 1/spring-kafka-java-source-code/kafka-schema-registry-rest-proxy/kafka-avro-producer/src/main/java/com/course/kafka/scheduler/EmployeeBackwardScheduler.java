package com.course.kafka.scheduler;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.course.avro.data.EmployeeBackward;
import com.course.kafka.broker.producer.EmployeeBackwardProducer;

//@Service
public class EmployeeBackwardScheduler {

	@Autowired
	private EmployeeBackwardProducer producer;

	@Scheduled(fixedRate = 1000)
	public void publish() {
		var now = LocalTime.now();
		var data = EmployeeBackward.newBuilder().setFirstName("First name " + now).setLastName("Last name " + now)
				.build();

		producer.send(data);
	}

}
