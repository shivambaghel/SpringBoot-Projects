package com.course.avro.entity;

public class BookJson {

	private String title;
	private String author;
	private int price;

	public String getAuthor() {
		return author;
	}

	public int getPrice() {
		return price;
	}

	public String getTitle() {
		return title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "BookJson [title=" + title + ", author=" + author + ", price=" + price + "]";
	}

}
