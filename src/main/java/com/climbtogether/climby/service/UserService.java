package com.climbtogether.climby.service;

import com.climbtogether.climby.dto.UserDTO;
import com.climbtogether.climby.exceptions.UserNotFoundException;

public interface UserService {

	UserDTO resgisterUser(UserDTO createUserDTO);

	UserDTO modifyUser(UserDTO modifyUserDTO) throws UserNotFoundException;

	UserDTO getUserById(Integer id) throws UserNotFoundException;

	UserDTO getUserByEmail(String email) throws UserNotFoundException;
	
	Boolean hasReservations(Integer id)throws UserNotFoundException;;

	void removeUser(Integer id) throws UserNotFoundException;

}
