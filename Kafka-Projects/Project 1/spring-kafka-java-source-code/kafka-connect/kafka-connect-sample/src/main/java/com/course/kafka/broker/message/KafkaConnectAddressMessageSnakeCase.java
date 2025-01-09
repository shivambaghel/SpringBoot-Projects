package com.course.kafka.broker.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class KafkaConnectAddressMessageSnakeCase {

	private int addressId;
	private String address;
	private String city;
	private String postalCode;

	public String getAddress() {
		return address;
	}

	public int getAddressId() {
		return addressId;
	}

	public String getCity() {
		return city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "KafkaConnectAddressMessageSnakeCase [addressId=" + addressId + ", address=" + address + ", city=" + city
				+ ", postalCode=" + postalCode + "]";
	}

}
