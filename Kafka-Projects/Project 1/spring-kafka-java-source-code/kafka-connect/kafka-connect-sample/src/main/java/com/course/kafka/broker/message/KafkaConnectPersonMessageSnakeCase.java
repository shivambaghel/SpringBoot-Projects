package com.course.kafka.broker.message;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class KafkaConnectPersonMessageSnakeCase {

	private int personId;
	private String fullName;
	private String email;
	private List<KafkaConnectAddressMessageSnakeCase> addresses;

	public List<KafkaConnectAddressMessageSnakeCase> getAddresses() {
		return addresses;
	}

	public String getEmail() {
		return email;
	}

	public String getFullName() {
		return fullName;
	}

	public int getPersonId() {
		return personId;
	}

	public void setAddresses(List<KafkaConnectAddressMessageSnakeCase> addresses) {
		this.addresses = addresses;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	@Override
	public String toString() {
		return "KafkaConnectPersonMessageSnakeCase [personId=" + personId + ", fullName=" + fullName + ", email="
				+ email + ", addresses=" + addresses + "]";
	}

}
