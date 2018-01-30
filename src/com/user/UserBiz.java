package com.user;

import java.sql.Connection;
import java.util.ArrayList;

import com.frame.Biz;
import com.vo.Item;
import com.vo.User;

public class UserBiz extends Biz<User, String> {
	
	UserDao dao;
	
	public UserBiz() {
		dao = new UserDao();
	}
	
	@Override
	public void register(User o) throws Exception {
		Connection conn = getConnection();
		try {
			// User 정보를 입력
			dao.insert(o, conn);
			// User 가 보유하고 있는 Item 정보 입력
			dao.insertItem(o, conn);
			conn.commit();
		}catch (Exception e) {
			conn.rollback();
			throw e;
		}finally {
			close(conn);
		}
		
	}

	@Override
	public void remove(String i) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(User o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User get(String i) throws Exception{
		Connection conn = getConnection();
		User user = null;
		ArrayList<Item> list = null;
		try {
			//입력한 ID로 User 정보 조회
			user = dao.select(i, conn);
			//입력한 ID로 UserItem을 조회한다.
			list = dao.getItems(i, conn);
			//Item의 정보를 User에게 setting 한다.
			user.setItems(list);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}
		//user 정보를 리턴한다.
		return user;
	}

	@Override
	public ArrayList<User> get() throws Exception {
		Connection conn = getConnection();
		ArrayList<User> ulist = null;
		ArrayList<Item> ilist = null;
		try {
			//모든 User 정보를 조회한다.
			ulist = dao.select(conn);
			//각각의 User의 ID를 이용하여 User Item 정보를 조회한다.
			for(User u : ulist) {
				String us = u.getId();
				ilist = dao.getItems(us, conn);
				//각각의 User에게 Item 정보를 Setting 한다.
				u.setItems(ilist);								
			}
			/*
			 * ulist = dao.select(conn);
			 * for(User user: users){
			 * 		ilist = dao.getItems(user.getid(), conn);
			 * 		user.setItems(ilist);
			 * }
			 * 
			 * */	
			conn.commit();
		}catch(Exception e) {
			conn.rollback();			
		}finally {
			close(conn);
		}		
		//ArrayList 정보를 리턴한다.
		return ulist;
	}

}
