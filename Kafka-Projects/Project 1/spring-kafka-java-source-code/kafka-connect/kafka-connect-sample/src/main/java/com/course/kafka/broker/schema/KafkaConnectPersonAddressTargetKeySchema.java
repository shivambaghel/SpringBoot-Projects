package com.course.kafka.broker.schema;

import com.course.kafka.broker.schema.KafkaConnectSchema.Type;

public class KafkaConnectPersonAddressTargetKeySchema {

	private static KafkaConnectSchema instance;

	static {
		instance = new KafkaConnectSchema(Type.int32.toString(), false, null, null);
	}

	private KafkaConnectPersonAddressTargetKeySchema() {

	}

	public static KafkaConnectSchema instance() {
		return instance;
	}

}
