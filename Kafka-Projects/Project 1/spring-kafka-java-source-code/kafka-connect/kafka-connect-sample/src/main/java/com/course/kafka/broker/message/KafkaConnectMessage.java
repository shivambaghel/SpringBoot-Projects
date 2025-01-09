package com.course.kafka.broker.message;

import com.course.kafka.broker.schema.KafkaConnectSchema;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KafkaConnectMessage<T> {

	private KafkaConnectSchema schema;
	private T payload;

	public T getPayload() {
		return payload;
	}

	public KafkaConnectSchema getSchema() {
		return schema;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}

	public void setSchema(KafkaConnectSchema schema) {
		this.schema = schema;
	}

	@Override
	public String toString() {
		return "KafkaConnectMessage [schema=" + schema + ", payload=" + payload + "]";
	}

}
