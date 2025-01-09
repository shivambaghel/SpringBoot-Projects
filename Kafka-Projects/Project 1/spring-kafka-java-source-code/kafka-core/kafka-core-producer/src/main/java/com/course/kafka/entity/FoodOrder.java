package com.course.kafka.entity;

public class FoodOrder {

	private int amount;
	private String item;

	public FoodOrder() {

	}

	public FoodOrder(int amount, String item) {
		super();
		this.amount = amount;
		this.item = item;
	}

	public int getAmount() {
		return amount;
	}

	public String getItem() {
		return item;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "FoodOrder [amount=" + amount + ", item=" + item + "]";
	}

}
