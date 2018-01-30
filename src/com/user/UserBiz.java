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
			// User ������ �Է�
			dao.insert(o, conn);
			// User �� �����ϰ� �ִ� Item ���� �Է�
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
			//�Է��� ID�� User ���� ��ȸ
			user = dao.select(i, conn);
			//�Է��� ID�� UserItem�� ��ȸ�Ѵ�.
			list = dao.getItems(i, conn);
			//Item�� ������ User���� setting �Ѵ�.
			user.setItems(list);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}
		//user ������ �����Ѵ�.
		return user;
	}

	@Override
	public ArrayList<User> get() throws Exception {
		Connection conn = getConnection();
		ArrayList<User> ulist = null;
		ArrayList<Item> ilist = null;
		try {
			//��� User ������ ��ȸ�Ѵ�.
			ulist = dao.select(conn);
			//������ User�� ID�� �̿��Ͽ� User Item ������ ��ȸ�Ѵ�.
			for(User u : ulist) {
				String us = u.getId();
				ilist = dao.getItems(us, conn);
				//������ User���� Item ������ Setting �Ѵ�.
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
		//ArrayList ������ �����Ѵ�.
		return ulist;
	}

}
