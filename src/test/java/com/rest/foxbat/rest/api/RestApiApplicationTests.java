package com.rest.foxbat.rest.api;

import com.rest.foxbat.rest.api.dto.UserAddressDto;
import com.rest.foxbat.rest.api.dto.UserInfoDto;
import com.rest.foxbat.rest.api.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class RestApiApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	void testXmlBaseMapping() {
		UserAddressDto user = userService.findUserAddress(1);
		System.out.print(user.toString());
	}

	@Test
	void testAnnotationBaseMapping() {
		List<UserInfoDto> users = userService.findUsersInfo(Arrays.asList(1L));
		users.stream().forEach(u -> System.out.println(u.toString()));
	}

}
