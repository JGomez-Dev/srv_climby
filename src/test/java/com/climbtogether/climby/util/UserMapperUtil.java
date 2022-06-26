package com.climbtogether.climby.util;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.climbtogether.climby.domain.User;
import com.climbtogether.climby.dto.UserDTO;

public class UserMapperUtil {

	public static User generateTestUser() {
		User user = new User();
		user.setEmail("edu21061991@gmail.com");
		user.setExperience("5");
		user.setFullName("Eduardo Gomez");
		user.setId_user(1);
		user.setOutputs(5);
		user.setPhone("691675453");
		user.setRegistrationDate(null);
		user.setScore(new BigDecimal("8.1"));
		user.setUserPhoto("7");

		return user;

	}

	public static UserDTO generateTestUserDTO() {

		UserDTO createUserDTO = new UserDTO();
		createUserDTO.setEmail("edu21061991@gmail.com");
		createUserDTO.setExperience("5");
		createUserDTO.setFullName("Eduardo Gomez");
		createUserDTO.setId(1);
		createUserDTO.setOutputs(5);
		createUserDTO.setPhone("691675453");
		createUserDTO.setRegistrationDate(null);
		createUserDTO.setScore(new BigDecimal("8.1"));
		createUserDTO.setUserPhoto("7");
 
		return createUserDTO;

	}

}
