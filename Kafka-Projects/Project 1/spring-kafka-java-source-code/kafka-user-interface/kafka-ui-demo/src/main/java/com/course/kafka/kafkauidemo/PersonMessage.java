package com.course.kafka.kafkauidemo;

public class PersonMessage {

	private String name;

	private String address;

	public PersonMessage(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public String getName() {
		return name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PersonMessage [name=" + name + ", address=" + address + "]";
	}

}
