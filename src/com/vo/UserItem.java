package com.vo;

public class UserItem {
	private String userid;
	private int itemid;
	
	public UserItem() {
		// TODO Auto-generated constructor stub
	}

	public UserItem(String userid, int itemid) {
		this.userid = userid;
		this.itemid = itemid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserItem [userid=").append(userid).append(", itemid=").append(itemid).append("]");
		return builder.toString();
	}

	
	
}
