package com.course.kafka.kafkauidemo;

import org.apache.kafka.streams.StreamsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaUiApi {

	@Autowired
	private StreamsBuilder streamsBuilder;
	
	@GetMapping(value = "/api/topology")
	public String topology() {
		return streamsBuilder.build().describe().toString();
	}
	
}
