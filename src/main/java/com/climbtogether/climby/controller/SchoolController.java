package com.climbtogether.climby.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.climbtogether.climby.dto.SchoolDTO;
import com.climbtogether.climby.service.SchoolService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@Api(value = "/",tags = "Gestor de escuelasss")
@RequestMapping("/school")
public class SchoolController {
	
	
@Autowired private SchoolService schoolService;
	
	@ApiOperation(
			value = "Get school",
			notes = "Return the school information")
	
	@ApiResponses(
			value = {
					@ApiResponse(code = 201, message = "success"),
					@ApiResponse(code = 409, message = "conflict")
			})
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/schools", headers = "Accept=application/json")
	public List<SchoolDTO> getSchoolFindAll(){
		return schoolService.getSchoolFindAll();
	}
}