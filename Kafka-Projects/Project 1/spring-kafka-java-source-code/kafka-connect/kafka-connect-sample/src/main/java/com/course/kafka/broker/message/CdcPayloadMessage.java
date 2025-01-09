package com.course.kafka.broker.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CdcPayloadMessage<T> {

	private T before;
	private T after;
	private String op;
	private CdcSourceMessage source;

	public T getAfter() {
		return after;
	}

	public T getBefore() {
		return before;
	}

	public String getOp() {
		return op;
	}

	public CdcSourceMessage getSource() {
		return source;
	}

	public void setAfter(T after) {
		this.after = after;
	}

	public void setBefore(T before) {
		this.before = before;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public void setSource(CdcSourceMessage source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "CdcPayloadMessage [before=" + before + ", after=" + after + ", op=" + op + ", source=" + source + "]";
	}

}
