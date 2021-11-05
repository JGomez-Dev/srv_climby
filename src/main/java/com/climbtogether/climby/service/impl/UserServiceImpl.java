package com.climbtogether.climby.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.climbtogether.climby.domain.User;
import com.climbtogether.climby.dto.UserDTO;
import com.climbtogether.climby.mapper.UserMapper;
import com.climbtogether.climby.repository.UserRepository;
import com.climbtogether.climby.service.UserService;


@Service
public class UserServiceImpl implements UserService {
		
	private static final String MESSAGE_PROVINCE_NOT_FOUND = "Province id \"%s\" not found";
	private static final String MESSAGE_PROVINCE_ID_NULL = "Province id must not be null";
	
	@Autowired private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserDTO resgisterUser(UserDTO createUserDTO) {
		
		User user = userMapper.userDTOToUser(createUserDTO);
		
		User AttachedUser =userRepository.save(user);
		
		return userMapper.userToUserDTO(AttachedUser);
		
	}

	@Override
	public UserDTO getUserById(String id) {
		
		Optional<User> user = userRepository.findById(id.toString());

		return userMapper.userToUserDTO(user.get());
	}

	@Override
	public UserDTO modifyUser(UserDTO modifyUserDTO) {
		
		User user = userMapper.userDTOToUser(modifyUserDTO);
		String id = user.getId();
		Assert.notNull(id,MESSAGE_PROVINCE_ID_NULL);
		if(!userRepository.existsById(id.toString())) {
			//Hay que meter una excepcion
			return null;
		}
		
		User attachedUser = userRepository.save(user);
		
		return userMapper.userToUserDTO(attachedUser);
	}

	@Override
	public void removeUser(String id) {
		Assert.notNull(id,MESSAGE_PROVINCE_ID_NULL);
		Optional<User> attachedUser = userRepository.findById(id);
		if(attachedUser.isEmpty()) {
			//Excepcion
		}
		userRepository.deleteById(id);
		
		
		
		
	}

}
