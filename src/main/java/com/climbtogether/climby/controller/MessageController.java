package com.climbtogether.climby.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.climbtogether.climby.dto.DataDTO;
import com.climbtogether.climby.dto.MessageDTO;
import com.climbtogether.climby.exceptions.TravelNotFoundException;
import com.climbtogether.climby.service.MessageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "/", tags = "Gestor de mensajes")
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageService messageService;

	@ApiOperation(value = "Message creation", notes = "Message creation operation required for the creation of available message")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 409, message = "conflict")})
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public MessageDTO registerMessage(
			@Validated @RequestBody MessageDTO createMessageDTO) {
		return new DataDTO<>(messageService.resgisterMessage(createMessageDTO))
				.getData();
	}
	
	
	
	
	
	
	@ApiOperation(value = "Get messages by id travel", notes = "Return messages from a trip")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "success"),@ApiResponse(code = 409, message = "conflict") })
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/travel/{id}", headers = "Accept=application/json")
	public List<MessageDTO> modifyMessageByTravelId(@ApiParam(name = "id", type = "Integer", value = "Intake code or CIO that identifies a travel", required = true, example = "1") @PathVariable Integer id) throws TravelNotFoundException {
		 return messageService.modifyMessageByTravelId(id);
	}
	
	
	
}
