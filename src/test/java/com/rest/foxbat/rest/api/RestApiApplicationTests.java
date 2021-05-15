package com.rest.foxbat.rest.api;

import com.rest.foxbat.rest.api.dao.UserDao;
import com.rest.foxbat.rest.api.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class RestApiApplicationTests {

	@Autowired
	private UserDao userDao;
	@Test
	void contextLoads() {
		List<Long> ids = new ArrayList<Long>(Arrays.asList(1L,2L));
		List<User> user = userDao.findByIds(ids);
		System.out.print("number of user " + user.get(0).toString());
	}

}
