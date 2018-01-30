package com.user.test;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.frame.Biz;
import com.user.UserBiz;
import com.vo.Item;
import com.vo.User;

class UserBizTest {

	@Test
	void testRegisterUser() {
		Biz<User, String> biz = new UserBiz();
		ArrayList<Item> list = new ArrayList<>();
		list.add(new Item(100, "k1", 1000));
		list.add(new Item(200, "k2", 2000));
		User user = new User("id04", "pwd04", "황말숙");
		user.setItems(list);
		try {
			biz.register(user);
			System.out.println("입력 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
