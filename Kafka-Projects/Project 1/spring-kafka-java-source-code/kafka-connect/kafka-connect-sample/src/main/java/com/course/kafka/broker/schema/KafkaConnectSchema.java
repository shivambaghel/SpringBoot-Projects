package com.course.kafka.broker.schema;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KafkaConnectSchema {

	public enum Type {
		struct, string, int32
	}

	private String type;
	private boolean optional;
	private String field;
	private List<KafkaConnectSchema> fields;

	public KafkaConnectSchema() {

	}

	public KafkaConnectSchema(String type, boolean optional, String field, List<KafkaConnectSchema> fields) {
		super();
		this.type = type;
		this.optional = optional;
		this.field = field;
		this.fields = fields;
	}

	public String getField() {
		return field;
	}

	public List<KafkaConnectSchema> getFields() {
		return fields;
	}

	public String getType() {
		return type;
	}

	public boolean isOptional() {
		return optional;
	}

	public void setField(String field) {
		this.field = field;
	}

	public void setFields(List<KafkaConnectSchema> fields) {
		this.fields = fields;
	}

	public void setOptional(boolean optional) {
		this.optional = optional;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "KafkaConnectSchema [type=" + type + ", optional=" + optional + ", field=" + field + ", fields=" + fields
				+ "]";
	}
}
