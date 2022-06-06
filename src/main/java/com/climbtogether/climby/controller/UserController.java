package com.climbtogether.climby.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.climbtogether.climby.dto.DataDTO;
import com.climbtogether.climby.dto.UserDTO;
import com.climbtogether.climby.exceptions.UserNotFoundException;
import com.climbtogether.climby.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "/", tags = "Gestor de usuarios")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "Get user by id", notes = "Return the user information")

	@ApiResponses(value = {@ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 401, message = "Unathorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not found")})
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/{id}", headers = "Accept=application/json")
	public UserDTO getUserById(
			@ApiParam(name = "id", type = "Integer", value = "Intake code or CIO that identifies a province", required = true, example = "1") @PathVariable Integer id)
			throws UserNotFoundException {
		return new DataDTO<>(userService.getUserById(id)).getData();
	}

	@ApiResponses(value = {@ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 401, message = "Unathorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not found")})
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/email/{email}", headers = "Accept=application/json")
	public UserDTO getUserByEmail(
			@ApiParam(name = "email", type = "String", value = "Intake code or CIO that identifies a province", required = true, example = "edu21061991@gmail.com") @PathVariable String email)
			throws UserNotFoundException {
		return new DataDTO<>(userService.getUserByEmail(email)).getData();
	}

	@ApiOperation(value = "User creation", notes = "User creation operation required for the creation of available user")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 401, message = "Unathorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 409, message = "Conflic"),
			@ApiResponse(code = 500, message = "Error")})
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public UserDTO registerUser(@Validated @RequestBody UserDTO createUserDTO) {
		return new DataDTO<>(userService.resgisterUser(createUserDTO))
				.getData();
	}

	@ApiOperation(value = "User modification", notes = "Return User information modificated")

	@ApiResponses(value = {@ApiResponse(code = 201, message = "success"),
			@ApiResponse(code = 409, message = "conflict")})
	@ResponseStatus(HttpStatus.OK)
	@PutMapping
	public UserDTO modifyUser(
			@ApiParam(name = "User", type = "User", value = "User type entity", required = true) @RequestBody @Validated UserDTO modifiedUserDTO)
			throws UserNotFoundException {
		return new DataDTO<>(userService.modifyUser(modifiedUserDTO)).getData();
	}

	@ApiOperation(value = "User deletion", notes = "Return user information deleted")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Accepted")})
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> removeUser(
			@ApiParam(name = "id", type = "String", value = "Identification code of the user to be removed", required = true, example = "1") @PathVariable Integer id)
			throws UserNotFoundException {
		userService.removeUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
