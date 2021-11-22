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
import com.climbtogether.climby.dto.ReservationDTO;
import com.climbtogether.climby.service.ReservationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "/",tags = "Gestor de reservas")
@RequestMapping("/reservation")
public class ReservationController {
	
	@Autowired 
	ReservationService reservationService;
	
	@ApiOperation(
			value = "Get reservation by id",
			notes = "Return the reservation information")
	
	@ApiResponses(
			value = {
					@ApiResponse(code = 201, message = "success"),
					@ApiResponse(code = 409, message = "conflict")
			})
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/{id}", headers = "Accept=application/json")
	public ReservationDTO getReservationById(
			@ApiParam(
					name = "id",
					type = "String",
					value = "Intake code or CIO that identifies a reservation",
					required = true,
					example =  "1")
			@PathVariable
			Integer id){
		return new DataDTO<>(reservationService.getReservationById(id)).getData();
	}
	
	@ApiOperation(
			value = "Reservation creation",
			notes = "Reservation creation operation required for the creation of available reservation")
	@ApiResponses(
			value = {
					@ApiResponse(code = 201, message = "created"),
					@ApiResponse(code = 409, message = "conflict")
			})
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public ReservationDTO registerReservation(@Validated @RequestBody ReservationDTO createReservationDTO){
		return new DataDTO<>(reservationService.resgisterReservation(createReservationDTO)).getData();
	}
	
	@ApiOperation(
			value = "Reservation modification",
			notes = "Return Reservation information modificated")
	
	@ApiResponses(
			value = {
					@ApiResponse(code = 201, message = "success"),
					@ApiResponse(code = 409, message = "conflict")
			})
	@ResponseStatus(HttpStatus.OK)
	@PutMapping
	public ReservationDTO modifyReservation(
		@ApiParam (	name = "Reservation",
			type = "Reservation",
			value = "Reservation type entity",
			required = true)
	@RequestBody
	@Validated
	ReservationDTO modifiedReservationDTO){
		return new DataDTO<>(reservationService.modifyReservation(modifiedReservationDTO)).getData();
	}
	
	@ApiOperation(value = "Reservation deletion",notes = "Return reservation information deleted")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Accepted")})
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> removeReservation(
			@ApiParam (	name = "id",
						type = "Integer",
						value = "Identification code of the reservation to be removed",
						required = true,
						example = "1")
			@PathVariable
			Integer id){
		reservationService.removeReservation(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	

	
	
}
