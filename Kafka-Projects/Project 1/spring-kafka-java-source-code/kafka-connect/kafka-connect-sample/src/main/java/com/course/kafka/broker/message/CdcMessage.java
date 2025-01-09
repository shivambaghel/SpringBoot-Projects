package com.course.kafka.broker.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CdcMessage<T> {
	
	private CdcPayloadMessage<T> payload;

	public CdcPayloadMessage<T> getPayload() {
		return payload;
	}

	public void setPayload(CdcPayloadMessage<T> payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return "CdcMessage [payload=" + payload + "]";
	}

}
