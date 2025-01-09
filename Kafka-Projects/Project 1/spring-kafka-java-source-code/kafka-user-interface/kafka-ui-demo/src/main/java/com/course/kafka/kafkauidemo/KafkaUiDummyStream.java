package com.course.kafka.kafkauidemo;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaUiDummyStream {

	@Bean
	public KStream<String, String> kstreamDummy(StreamsBuilder builder) {
		var sourceStream = builder.stream("t-ui-demo-one", Consumed.with(Serdes.String(), Serdes.String()));
		sourceStream.mapValues(s -> s.toUpperCase()).to("t-ui-demo-one-stream-uppercase-output",
				Produced.with(Serdes.String(), Serdes.String()));
		sourceStream.filter((k, v) -> v.toLowerCase().contains("true")).to("t-ui-demo-one-stream-true-only-output");

		return sourceStream;
	}

	@Bean
	public KStream<String, String> kstreamDummyTwoLowercase(StreamsBuilder builder) {
		var sourceStream = builder.stream("t-ui-demo-two", Consumed.with(Serdes.String(), Serdes.String()));
		sourceStream.mapValues(s -> s.toLowerCase()).to("t-ui-demo-two-stream-lowercase-output",
				Produced.with(Serdes.String(), Serdes.String()));

		return sourceStream;
	}

}
