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

import com.climbtogether.climby.domain.Travel;
import com.climbtogether.climby.dto.DataDTO;
import com.climbtogether.climby.dto.ProvinceDTO;
import com.climbtogether.climby.dto.TravelDTO;
import com.climbtogether.climby.service.TravelService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@Api(value = "/",tags = "Gestor de viajes")
@RequestMapping("/travel")
public class TravelController {
	
	//Muestra todos los viajes excepto los del usuario indicado
@Autowired private TravelService travelService;


@ApiOperation(
		value = "Get all travels",
		notes = "Return the travel information")

@ApiResponses(
		value = {
				@ApiResponse(code = 201, message = "success"),
				@ApiResponse(code = 409, message = "conflict")
		})
@ResponseStatus(HttpStatus.OK)
@GetMapping(value = "/travels", headers = "Accept=application/json")
	public List<TravelDTO> getTravelFindAll(){
	return travelService.getTravelFindAll();
}
@ApiOperation(
		value = "Get the trips of a user",
		notes = "Return the travel information")

@ApiResponses(
		value = {
				@ApiResponse(code = 201, message = "success"),
				@ApiResponse(code = 409, message = "conflict")
		})
@ResponseStatus(HttpStatus.OK)
@GetMapping(value = "/users/{id}", headers = "Accept=application/json")
	public List<TravelDTO> getUsersTravels(

		@ApiParam(
				name = "id",
				type = "Integer",
				value = "Intake code or CIO that identifies a travel",
				required = true,
				example =  "1")
		@PathVariable
		Integer id){
	return travelService.getUsersTravels(id);
}
	@ApiOperation(
			value = "Displays trips booked by a given user",
			notes = "Return the travel information")
	
	@ApiResponses(
			value = {
					@ApiResponse(code = 201, message = "success"),
					@ApiResponse(code = 409, message = "conflict")
			})
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "reservations/idUser/{id}", headers = "Accept=application/json")
	public List<TravelDTO> getTravelsWithUserReservation(

			@ApiParam(
					name = "id",
					type = "Integer",
					value = "Intake code or CIO that identifies a travel",
					required = true,
					example =  "1")
			@PathVariable
			Integer id){
		return travelService.getTravelsWithUserReservation(id);
	}
	@ApiOperation(
			value = "Travel creation",
			notes = "Travel creation operation required for the creation of available travel")
	@ApiResponses(
			value = {
					@ApiResponse(code = 201, message = "created"),
					@ApiResponse(code = 409, message = "conflict")
			})
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public DataDTO<TravelDTO> registerTravel(@Validated @RequestBody TravelDTO createTravelDTO){
		return new DataDTO<>(travelService.resgisterTravel(createTravelDTO));
	}
	@ApiOperation(
			value = "Travel modification",
			notes = "Return Travel information modificated")
	
	@ApiResponses(
			value = {
					@ApiResponse(code = 201, message = "success"),
					@ApiResponse(code = 409, message = "conflict")
			})
	@ResponseStatus(HttpStatus.OK)
	@PutMapping
	public DataDTO<TravelDTO> modifyTravel(
		@ApiParam (	name = "Travel",
			type = "Travel",
			value = "Travel type entity",
			required = true)
	@RequestBody
	@Validated
	TravelDTO modifiedTravelDTO){
		return new DataDTO<>(travelService.modifyTravel(modifiedTravelDTO));
	}
	@ApiOperation(value = "Travel deletion",notes = "Return travel information deleted")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Accepted")})
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> removeTravel(
			@ApiParam (	name = "id",
						type = "Integer",
						value = "Identification code of the travel to be removed",
						required = true,
						example = "1")
			@PathVariable
			Integer id){
		travelService.removeTravel(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}