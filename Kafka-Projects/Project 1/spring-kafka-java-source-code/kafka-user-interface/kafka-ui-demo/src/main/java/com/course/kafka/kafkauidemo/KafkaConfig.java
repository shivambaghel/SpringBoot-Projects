package com.course.kafka.kafkauidemo;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

	@Bean
	public NewTopic topicOne() {
		return TopicBuilder.name("t-ui-demo-one").partitions(8).replicas(1).build();
	}

	@Bean
	public NewTopic topicTwo() {
		return TopicBuilder.name("t-ui-demo-two").partitions(5).replicas(1).build();
	}

}
