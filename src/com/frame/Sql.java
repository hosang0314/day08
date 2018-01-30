package com.frame;

public class Sql {
	
	public static String insertUserItem = "INSERT INTO T_USERITEM VALUES (?,?)";
	public static String insertUser = "INSERT INTO T_USER VALUES (?,?,?)";
	public static String selectUserItem = "SELECT it.id id, it.name name, it.price price " + 
			"  FROM T_USER us, T_ITEM it, T_USERITEM ui " + 
			" WHERE us.id = ui.userid" + 
			"   AND ui.itemid = it.id" + 
			"   AND us.id = ?";
	public static String selectAllUser = "SELECT * FROM T_USER";
	public static String selectUser = "SELECT * FROM T_USER WHERE ID = ?";
		
}
