package com.course.kafka.broker.message;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderPatternMessage {

	private String itemName;
	
	private long totalItemAmount;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private  LocalDateTime orderDateTime;
	
	private String orderLocation;
	
	private String orderNumber;

	public String getItemName() {
		return itemName;
	}

	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}

	public String getOrderLocation() {
		return orderLocation;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public long getTotalItemAmount() {
		return totalItemAmount;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public void setOrderLocation(String orderLocation) {
		this.orderLocation = orderLocation;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public void setTotalItemAmount(long totalItemAmount) {
		this.totalItemAmount = totalItemAmount;
	}

	@Override
	public String toString() {
		return "OrderPatternMessage [itemName=" + itemName + ", totalItemAmount=" + totalItemAmount + ", orderDateTime="
				+ orderDateTime + ", orderLocation=" + orderLocation + ", orderNumber=" + orderNumber + "]";
	}
}
