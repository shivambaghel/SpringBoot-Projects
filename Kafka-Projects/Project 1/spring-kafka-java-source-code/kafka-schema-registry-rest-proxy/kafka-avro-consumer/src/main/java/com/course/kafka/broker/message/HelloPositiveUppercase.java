package com.course.kafka.broker.message;

public class HelloPositiveUppercase {

	private int positiveInt;
	
	private String uppercaseString;

	public int getPositiveInt() {
		return positiveInt;
	}

	public String getUppercaseString() {
		return uppercaseString;
	}

	public void setPositiveInt(int positiveInt) {
		this.positiveInt = positiveInt;
	}

	public void setUppercaseString(String uppercaseString) {
		this.uppercaseString = uppercaseString;
	}

	@Override
	public String toString() {
		return "HelloPositiveUppercase [positiveInt=" + positiveInt + ", uppercaseString=" + uppercaseString + "]";
	}
	
}
