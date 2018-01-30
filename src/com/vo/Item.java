package com.vo;

public class Item {
	private int id;
	private String name;
	private int price;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	public Item(int id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Item [id=").append(id).append(", name=").append(name).append(", price=").append(price)
				.append("]");
		return builder.toString();
	}


	
}
