package com.climbtogether.app.service;



import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.climbtogether.app.util.UserMapperUtil;
import com.climbtogether.climby.domain.User;
import com.climbtogether.climby.dto.UserDTO;
import com.climbtogether.climby.mapper.UserMapper;
import com.climbtogether.climby.repository.UserRepository;
import com.climbtogether.climby.service.impl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest{
	
	@Mock
	UserRepository userRespository = mock(UserRepository.class);
	
	@Mock
	UserMapper userMapper = mock(UserMapper.class);
	
	@Mock
	UserServiceImpl userServiceImpl = mock(UserServiceImpl.class);
	
	@Test
	public void testResgisterUser() {
		//Given
		UserDTO userDTO = UserMapperUtil.generateTestUserDTO();
		User user = UserMapperUtil.generateTestUser();
		
		User attackedUser = UserMapperUtil.generateTestUser();
		UserDTO attackedUserDTO = UserMapperUtil.generateTestUserDTO();
		
		when(userMapper.userDTOToUser(userDTO)).thenReturn(user);
		when(userRespository.save(user)).thenReturn(attackedUser);
		when(userMapper.userToUserDTO(attackedUser)).thenReturn(attackedUserDTO);
			
	}

}
