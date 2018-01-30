package com.vo;

import java.util.ArrayList;

public class User {
	private String id;
	private String pwd;
	private String name;
	ArrayList<Item> items;
	
	public User() {
	}

	public User(String id, String pwd, String name) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
	}

	public User(String id, String pwd, String name, ArrayList<Item> items) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.items = items;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=").append(id).append(", pwd=").append(pwd).append(", name=").append(name).append("]");
		return builder.toString();
	}
	
	
	
	
	
	
}
