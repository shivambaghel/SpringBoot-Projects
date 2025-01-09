package com.course.kafka.broker.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketingSalesMessage {

	private int salesId;
	private int salesAmount;
	private String salesCurrency;

	@JsonProperty("sales_date")
	private int salesEpochDays;

	private String customerEmail;

	public String getCustomerEmail() {
		return customerEmail;
	}

	public int getSalesAmount() {
		return salesAmount;
	}

	public String getSalesCurrency() {
		return salesCurrency;
	}

	public int getSalesEpochDays() {
		return salesEpochDays;
	}

	public int getSalesId() {
		return salesId;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public void setSalesAmount(int salesAmount) {
		this.salesAmount = salesAmount;
	}

	public void setSalesCurrency(String salesCurrency) {
		this.salesCurrency = salesCurrency;
	}

	public void setSalesEpochDays(int salesEpochDays) {
		this.salesEpochDays = salesEpochDays;
	}

	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}

	@Override
	public String toString() {
		return "MarketingSalesMessage [salesId=" + salesId + ", salesAmount=" + salesAmount + ", salesCurrency="
				+ salesCurrency + ", salesEpochDays=" + salesEpochDays + ", customerEmail=" + customerEmail + "]";
	}

}
