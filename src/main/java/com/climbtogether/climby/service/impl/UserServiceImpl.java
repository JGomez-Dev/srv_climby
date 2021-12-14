package com.climbtogether.climby.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.server.ResponseStatusException;

import com.climbtogether.climby.domain.User;
import com.climbtogether.climby.dto.UserDTO;
import com.climbtogether.climby.mapper.UserMapper;
import com.climbtogether.climby.repository.UserRepository;
import com.climbtogether.climby.service.UserService;
import com.climbtogether.climby.util.RegularExpression;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private RegularExpression regularExpression;

	@Override
	public UserDTO resgisterUser(UserDTO createUserDTO) {

		if (!regularExpression.checkPhone(createUserDTO.getPhone())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Wrong phone number");
		}
		;

		createUserDTO.setRegistrationDate(LocalDateTime.now());

		User user = userMapper.userDTOToUser(createUserDTO);

		User AttachedUser = userRepository.save(user);

		return userMapper.userToUserDTO(AttachedUser);

	}

	@Override
	public UserDTO getUserById(Integer id) {

		Optional<User> user = userRepository.findById(id);

		if (user.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return userMapper.userToUserDTO(user.get());
	}

	@Override
	public UserDTO modifyUser(UserDTO modifyUserDTO) {

		User user = userMapper.userDTOToUser(modifyUserDTO);
		Integer id = user.getId_user();

		if (!userRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		User attachedUser = userRepository.save(user);

		return userMapper.userToUserDTO(attachedUser);
	}

	@Override
	public void removeUser(Integer id) {
		Optional<User> attachedUser = userRepository.findById(id);
		if (attachedUser.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		userRepository.deleteById(id);

	}

}
