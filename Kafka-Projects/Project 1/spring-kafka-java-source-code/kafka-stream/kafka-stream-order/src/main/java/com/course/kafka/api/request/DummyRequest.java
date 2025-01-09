package com.course.kafka.api.request;

import io.swagger.v3.oas.annotations.media.Schema;

public class DummyRequest {

	@Schema(description = "Refer to www.google.com", example = "Peter", maxLength = 100, minLength = 3)
	private String firstName;

	private int age;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
