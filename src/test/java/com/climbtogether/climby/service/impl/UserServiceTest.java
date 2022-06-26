//package com.climbtogether.climby.service.impl;
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//import com.climbtogether.climby.dto.UserDTO;
//import com.climbtogether.climby.service.UserService;
//import com.climbtogether.climby.util.UserMapperUtil;
//
//
//public class UserServiceTest {
//
//	UserDTO userDTO = UserMapperUtil.generateTestUserDTO();
//
//	@Test
//	void testresgisterUser()throws Exception {	
//		UserService userService = Mockito.mock(UserService.class);;
//		when(userService.resgisterUser(userDTO)).thenReturn(userDTO);
//		//2. Ejecución
//		userDTO = userService.resgisterUser(userDTO);
//		assertEquals(userDTO, userDTO);	
//		
//	}
//	
//}
