package com.user.test;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.frame.Biz;
import com.user.UserBiz;
import com.vo.User;

class UserSelectBizTest {

	@Test
	void testGetString() {
		Biz<User, String> biz = new UserBiz();
		String i = "id04";
		try {
			System.out.println("=========1¸í============");
			System.out.println(biz.get(i));
			System.out.println(biz.get(i).getItems());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testGet() {
		Biz<User, String> biz = new UserBiz();
		try {
			ArrayList<User> list = null;
			list = biz.get();
			System.out.println("========ÀüÃ¼==============");
			for (User u : list) {
				System.out.println(u);
				System.out.println(u.getItems());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
