package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.frame.Dao;
import com.frame.Sql;
import com.vo.Item;
import com.vo.User;

public class UserDao extends Dao<User, String> {

	public ArrayList<Item> getItems(String i, Connection conn) throws Exception {
		ArrayList<Item> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(Sql.selectUserItem);
			pstmt.setString(1, i);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Item item = null;
				int id = rset.getInt("id");
				String name = rset.getString("name");
				int price = rset.getInt("price");
				item = new Item(id,name,price);
				list.add(item);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (rset != null)
				close(rset);
			if (rset != null)
				close(pstmt);
		}
		return list;
	}

	public void insertItem(User o, Connection conn) throws Exception {
		ArrayList<Item> items = o.getItems(); // useritem에 넣기 위해 user가 가지고 있는 item 정보를 가져옴
		String id = o.getId();
		PreparedStatement pstmt = null;
		try {
			for (Item item : items) {
				pstmt = conn.prepareStatement(Sql.insertUserItem);
				pstmt.setString(1, id);
				pstmt.setInt(2, item.getId());
				pstmt.executeUpdate();
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}
	}

	@Override
	public void insert(User o, Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.insertUser);
			pstmt.setString(1, o.getId());
			pstmt.setString(2, o.getPwd());
			pstmt.setString(3, o.getName());
			pstmt.executeUpdate();

		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}

	}

	@Override
	public void delete(String i, Connection conn) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(User o, Connection conn) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public User select(String i, Connection conn) throws Exception {
		User user = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(Sql.selectUser);
			pstmt.setString(1, i);
			rset = pstmt.executeQuery();
			rset.next();
			String id = rset.getString("id");
			String pwd = rset.getString("pwd");
			String name = rset.getString("name");
			user = new User(id, pwd, name);
		} catch (Exception e) {
			throw e;
		} finally {
			if (rset != null)
				close(rset);
			if (pstmt != null)
				close(pstmt);
		}
		return user;
	}

	@Override
	public ArrayList<User> select(Connection conn) throws Exception {
		ArrayList<User> ulist = new ArrayList<>();
		ArrayList<Item> ilist = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		User user = null;
		try {
			pstmt = conn.prepareStatement(Sql.selectAllUser);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				String id = rset.getString("id");
				String pwd = rset.getString("pwd");
				String name = rset.getString("name");
				user = new User(id, pwd, name);
				ilist = getItems(id, conn);
				ulist.add(user);
				user.setItems(ilist);				
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (rset != null)
				close(rset);
			if (pstmt != null)
				close(pstmt);
		}
		return ulist;
	}

}
