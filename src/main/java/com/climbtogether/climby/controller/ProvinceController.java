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
		
	
}


