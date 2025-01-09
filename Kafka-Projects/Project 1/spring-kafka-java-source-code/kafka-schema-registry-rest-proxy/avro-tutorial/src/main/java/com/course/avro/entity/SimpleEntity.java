package com.course.avro.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SimpleEntity {

	private String simpleString;

	private float simpleFloat;

	private boolean simpleBoolean;

	private LocalDate simpleDate;

	private BigDecimal simpleDecimal;

	public LocalDate getSimpleDate() {
		return simpleDate;
	}

	public BigDecimal getSimpleDecimal() {
		return simpleDecimal;
	}

	public float getSimpleFloat() {
		return simpleFloat;
	}

	public String getSimpleString() {
		return simpleString;
	}

	public boolean isSimpleBoolean() {
		return simpleBoolean;
	}

	public void setSimpleBoolean(boolean simpleBoolean) {
		this.simpleBoolean = simpleBoolean;
	}

	public void setSimpleDate(LocalDate simpleDate) {
		this.simpleDate = simpleDate;
	}

	public void setSimpleDecimal(BigDecimal simpleDecimal) {
		this.simpleDecimal = simpleDecimal;
	}

	public void setSimpleFloat(float simpleFloat) {
		this.simpleFloat = simpleFloat;
	}

	public void setSimpleString(String simpleString) {
		this.simpleString = simpleString;
	}

}
