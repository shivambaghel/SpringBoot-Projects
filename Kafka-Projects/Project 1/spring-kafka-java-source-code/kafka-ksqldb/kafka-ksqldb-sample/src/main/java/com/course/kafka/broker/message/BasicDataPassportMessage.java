package com.course.kafka.broker.message;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BasicDataPassportMessage {

	private String number;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate expiryDate;

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public String getNumber() {
		return number;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "BasicDataPassportMessage [number=" + number + ", expiryDate=" + expiryDate + "]";
	}

}
