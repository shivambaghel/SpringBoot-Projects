package com.course.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.course.kafka.ksqldb.client.BasicJavaClient;

@SpringBootApplication
public class KafkaKsqldbSampleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(KafkaKsqldbSampleApplication.class, args);
	}

	private static final Logger LOG = LoggerFactory.getLogger(KafkaKsqldbSampleApplication.class);

	@Autowired
	private BasicJavaClient basicJavaClient;

	@Override
	public void run(String... args) throws Exception {
//		basicJavaClient.createStream();	
//		basicJavaClient.describeStream();
//		basicJavaClient.listObjects();

//		for (int i = 0; i < 5; i++) {
//			basicJavaClient.insertSingle();
//		}

//		basicJavaClient.insertStream(10);

//		basicJavaClient.pullQuery();

//		LOG.info("Starting pushQuerySync()");
//		basicJavaClient.pushQuerySync();
//		LOG.info("Done pushQuerySync()");

		LOG.info("Starting pushQueryAsync()");
		basicJavaClient.pushQueryAsync();
		LOG.info("Done pushQueryAsync()");
	}

}
