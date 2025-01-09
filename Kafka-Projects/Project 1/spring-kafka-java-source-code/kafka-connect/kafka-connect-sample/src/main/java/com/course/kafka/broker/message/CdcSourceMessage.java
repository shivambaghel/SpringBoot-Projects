package com.course.kafka.broker.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CdcSourceMessage {

	private String schema;
	private String table;

	public String getSchema() {
		return schema;
	}

	public String getTable() {
		return table;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public void setTable(String table) {
		this.table = table;
	}

	@Override
	public String toString() {
		return "CdcSourceMessage [schema=" + schema + ", table=" + table + "]";
	}

}
