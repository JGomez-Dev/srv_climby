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

import com.climbtogether.climby.dto.ConsultationSchoolResponseDTO;
import com.climbtogether.climby.dto.CreateSchoolDTO;
import com.climbtogether.climby.dto.DataDTO;
import com.climbtogether.climby.dto.ModifiedSchoolDTO;
import com.climbtogether.climby.dto.SchoolDTO;
import com.climbtogether.climby.service.SchoolService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "/",tags = "Gestor de escuelas")
@RequestMapping("/school")
public class SchoolController {

	@Autowired private SchoolService schoolService;
	
	@ApiOperation(
			value = "Get School by id",
			notes = "Return the school information")
	
	@ApiResponses(
			value = {
					@ApiResponse(code = 200, message = "success"),
					@ApiResponse(code = 409, message = "conflict")
			})
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/{id}", headers = "Accept=application/json")
	public DataDTO<ConsultationSchoolResponseDTO> getSchoolById(
			@ApiParam(
					name = "id",
					type = "String",
					value = "Intake code or CIO that identifies a school",
					required = true,
					example =  "1")
			@PathVariable
			String id) {
		return new DataDTO<>(schoolService.getSchoolById(id));
	}
	
	@ApiOperation(
			value = "School creation",
			notes = "School creation operation required for the creation of available school")
	@ApiResponses(
			value = {
					@ApiResponse(code = 201, message = "created"),
					@ApiResponse(code = 409, message = "conflict")
			})
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public DataDTO<SchoolDTO> registerSchool(@Validated @RequestBody CreateSchoolDTO createSchoolDTO) {
		return new DataDTO<>(schoolService.resgisterSchool(createSchoolDTO));
	}
	
	@ApiOperation(
			value = "School modification",
			notes = "Return school information modificated")
	
	@ApiResponses(
			value = {
					@ApiResponse(code = 201, message = "success"),
					@ApiResponse(code = 409, message = "conflict")
			})
	@ResponseStatus(HttpStatus.OK)
	@PutMapping
	public DataDTO<SchoolDTO> modifySchool(
		@ApiParam (	name = "School",
			type = "School",
			value = "School type entity",
			required = true)
	@RequestBody
	@Validated
	ModifiedSchoolDTO modifiedSchoolDTO){
		return new DataDTO<>(schoolService.modifySchool(modifiedSchoolDTO));
	}
	
	@ApiOperation(value = "School deletion",notes = "Return school information deleted")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Accepted")})
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> removeSchool(
			@ApiParam (	name = "id",
						type = "String",
						value = "Identification code of the school to be removed",
						required = true,
						example = "1")
			@PathVariable
			String id){
		schoolService.removeSchool(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}


