package com.course.kafka.broker.message;

import java.util.List;

public class PersonMessage {

	private int personId;
	private String fullName;
	private String email;
	private List<AddressMessage> addresses;

	public List<AddressMessage> getAddresses() {
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

	public void setAddresses(List<AddressMessage> addresses) {
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
		return "PersonMessage [personId=" + personId + ", fullName=" + fullName + ", email=" + email + ", addresses="
				+ addresses + "]";
	}

}
