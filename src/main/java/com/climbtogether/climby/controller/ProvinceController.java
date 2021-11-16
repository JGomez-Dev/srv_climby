package com.climbtogether.climby.controller;

import java.util.List;

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
import com.climbtogether.climby.dto.ProvinceDTO;
import com.climbtogether.climby.dto.TravelDTO;
import com.climbtogether.climby.service.ProvinceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "/",tags = "Gestor de provincias")
@RequestMapping("/province")
public class ProvinceController {

	@Autowired private ProvinceService provinceService;
	
	
	@ApiOperation(
			value = "Get all province",
			notes = "Return the province information")
	
	@ApiResponses(
			value = {
					@ApiResponse(code = 201, message = "success"),
					@ApiResponse(code = 409, message = "conflict")
			})
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/provinces", headers = "Accept=application/json")
	public List<ProvinceDTO> getProvinceFindAll(){
		return provinceService.getProvinceFindAll();
	}
	
//	@ApiOperation(
//			value = "Get Province by id",
//			notes = "Return the province information")
//	
//	@ApiResponses(
//			value = {
//					@ApiResponse(code = 200, message = "success"),
//					@ApiResponse(code = 409, message = "conflict")
//			})
//	@ResponseStatus(HttpStatus.OK)
//	@GetMapping(value = "/{id}", headers = "Accept=application/json")
//	public DataDTO<ProvinceDTO> getProvinceById(
//			@ApiParam(
//					name = "id",
//					type = "String",
//					value = "Intake code or CIO that identifies a province",
//					required = true,
//					example =  "1")
//			@PathVariable
//			String id){
//		return new DataDTO<>(provinceService.getProvinceById(id));
//	}
	
//	@ApiOperation(
//			value = "Province creation",
//			notes = "Province creation operation required for the creation of available province")
//	@ApiResponses(
//			value = {
//					@ApiResponse(code = 201, message = "created"),
//					@ApiResponse(code = 409, message = "conflict")
//			})
//	@ResponseStatus(HttpStatus.CREATED)
//	@PostMapping
//	public DataDTO<ProvinceDTO> registerProvince(@Validated @RequestBody ProvinceDTO createProvinceDTO) throws ProvinceExistsConflicExcepcion{
//		return new DataDTO<>(provinceService.resgisterProvince(createProvinceDTO));
//	}
	
//	@ApiOperation(
//			value = "Province modification",
//			notes = "Return province information modificated")
//	
//	@ApiResponses(
//			value = {
//					@ApiResponse(code = 201, message = "success"),
//					@ApiResponse(code = 409, message = "conflict")
//			})
//	@ResponseStatus(HttpStatus.OK)
//	@PutMapping
//	public DataDTO<ProvinceDTO> modifyProvince(
//		@ApiParam (	name = "Province",
//			type = "Province",
//			value = "Province type entity",
//			required = true)
//	@RequestBody
//	@Validated
//	ProvinceDTO modifiedProvinceDTO) throws ProvinceNotFoundException{
//		return new DataDTO<>(provinceService.modifyProvince(modifiedProvinceDTO));
//	}
//	
//	@ApiOperation(value = "Porvince deletion",notes = "Return province information deleted")
//	@ApiResponses(value = {@ApiResponse(code = 200, message = "Accepted")})
//	@ResponseStatus(HttpStatus.OK)
//	@DeleteMapping(value = "/{id}")
//	public ResponseEntity<Void> removeProvince(
//			@ApiParam (	name = "id",
//						type = "String",
//						value = "Identification code of the province to be removed",
//						required = true,
//						example = "1")
//			@PathVariable
//			String id) throws ProvinceNotFoundException{
//		provinceService.removeProvince(id);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
	
	
}


