//package com.climbtogether.climby.service.impl;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//
//import com.climbtogether.climby.domain.User;
//import com.climbtogether.climby.dto.UserDTO;
//import com.climbtogether.climby.mapper.UserMapper;
//import com.climbtogether.climby.repository.UserRepository;
//import com.climbtogether.climby.util.UserMapperUtil;
//
//public class UserServiceImplTest {
//
//	@Mock
//	UserRepository userRespository = mock(UserRepository.class);
//
//	@Mock
//	UserMapper userMapper = mock(UserMapper.class);
//	
//	@Mock
//	UserMapperUtil userMapperUtil = mock(UserMapperUtil.class);
//
//	@Mock
//	UserServiceImpl userServiceImpl = mock(UserServiceImpl.class);
//
//	@Test
//	public void testResgisterUser() {
//
//		UserDTO userDTO = userMapperUtil.generateTestUserDTO();
//		User user = userMapperUtil.generateTestUser();
//
//		User attackedUser = userMapperUtil.generateTestUser();
//		UserDTO attackedUserDTO = userMapperUtil.generateTestUserDTO();
//
//		when(userMapper.userDTOToUser(userDTO)).thenReturn(user);
//		when(userRespository.save(user)).thenReturn(attackedUser);
//		when(userMapper.userToUserDTO(attackedUser))
//				.thenReturn(attackedUserDTO);
//
//	}
//
//}
