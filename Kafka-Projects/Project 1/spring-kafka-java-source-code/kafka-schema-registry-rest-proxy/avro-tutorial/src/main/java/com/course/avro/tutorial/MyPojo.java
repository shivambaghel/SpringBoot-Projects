package com.course.avro.tutorial;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public class MyPojo {

	private BigDecimal pojoDecimal;
	private UUID pojoUUID;

	// should be avro date
	private LocalDate pojoDate;

	// should be avro time millis
	private LocalTime pojoTime;

	// should be avro timestamp millis
	private LocalDateTime pojoDateTime;

	public BigDecimal getPojoDecimal() {
		return pojoDecimal;
	}

	public void setPojoDecimal(BigDecimal pojoDecimal) {
		this.pojoDecimal = pojoDecimal;
	}

	public UUID getPojoUUID() {
		return pojoUUID;
	}

	public void setPojoUUID(UUID pojoUUID) {
		this.pojoUUID = pojoUUID;
	}

	public LocalDate getPojoDate() {
		return pojoDate;
	}

	public void setPojoDate(LocalDate pojoDate) {
		this.pojoDate = pojoDate;
	}

	public LocalTime getPojoTime() {
		return pojoTime;
	}

	public void setPojoTime(LocalTime pojoTime) {
		this.pojoTime = pojoTime;
	}

	public LocalDateTime getPojoDateTime() {
		return pojoDateTime;
	}

	public void setPojoDateTime(LocalDateTime pojoDateTime) {
		this.pojoDateTime = pojoDateTime;
	}

}
