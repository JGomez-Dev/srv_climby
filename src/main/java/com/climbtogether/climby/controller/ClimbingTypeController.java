package com.climbtogether.climby.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.climbtogether.climby.dto.ClimbingTypeDTO;
import com.climbtogether.climby.service.ClimbingTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@Api(value = "/",tags = "Gestor de tipo de escalada")
@RequestMapping("/type")
public class ClimbingTypeController {
	
	
@Autowired private ClimbingTypeService climbingTypeService;
	
	@ApiOperation(
			value = "Get climbing type",
			notes = "Return the climbing type information")
	
	@ApiResponses(
			value = {
					@ApiResponse(code = 201, message = "success"),
					@ApiResponse(code = 409, message = "conflict")
			})
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/types", headers = "Accept=application/json")
	public List<ClimbingTypeDTO> getClimbingTypeFindAll(){
		return climbingTypeService.getClimbingTypeFindAll();
	}
}