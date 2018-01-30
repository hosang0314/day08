package com.frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Biz<O,I> {
	protected Dao<O,I> dao;
	
	public Biz() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle Driver Not Found...");
		}
	}
	
	public Connection getConnection() {
		// Connection은 멤버변수로 할수 없다.
		// Connection을 멤버변수로 할경우 여러개의 Connection이 작업을 할수 있는 상황이 되어
		// 지역변수로 선언해서 사용해줘야 한다.

		Connection conn = null;
		String url = "jdbc:oracle:thin:@70.12.111.133:1521:XE";
		String user = "mv";
		String password = "mv";
		try {
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {

			}
		}
	}
	
	public abstract void register(O o) throws Exception;
	public abstract void remove(I i) throws Exception;
	public abstract void modify(O o) throws Exception;
	public abstract O get(I i) throws Exception;
	public abstract ArrayList<O> get() throws Exception;
	
}
