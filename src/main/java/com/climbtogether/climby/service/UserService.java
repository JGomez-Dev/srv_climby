package com.climbtogether.climby.service;

import com.climbtogether.climby.dto.UserDTO;


public interface UserService {

	UserDTO resgisterUser(UserDTO createUserDTO);
	
	UserDTO modifyUser(UserDTO modifyUserDTO);
	
	//UserDTO getUserById(Integer id);
	
	void removeUser(Integer id);
	
	

}
