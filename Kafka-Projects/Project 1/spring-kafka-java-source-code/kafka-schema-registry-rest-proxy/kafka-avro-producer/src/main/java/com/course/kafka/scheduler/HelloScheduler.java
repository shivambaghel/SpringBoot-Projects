package com.course.kafka.scheduler;

import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.course.avro.data.Hello;
import com.course.kafka.broker.producer.HelloProducer;

//@Service
public class HelloScheduler {

	@Autowired
	private HelloProducer producer;

	@Scheduled(fixedRate = 1000)
	public void publish() {
		var data = Hello.newBuilder().setMyIntField(ThreadLocalRandom.current().nextInt())
				.setMyStringField("Now is : " + LocalTime.now()).build();
		
		producer.send(data);
	}

}
