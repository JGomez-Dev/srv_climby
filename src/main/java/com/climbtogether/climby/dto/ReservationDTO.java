package com.climbtogether.climby.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.Null;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO implements Serializable {

	private static final long serialVersionUID = -3086160475938675275L;

	@ApiModelProperty(required = true, value = "Id reservation", example = "1")
	private Integer id;

	@ApiModelProperty(value = "User", example = "1")
	@JsonProperty(value = "userId")
	private UserDTO userDTO;

	@ApiModelProperty(value = "Travel", example = "1")
	@JsonProperty(value = "idTravel")
	private TravelDTO travelDTO;

	@ApiModelProperty(value = "Reservation Status", example = "true")
	@JsonProperty(value = "reservationStatus")
	private Boolean reservationStatus;

	@ApiModelProperty(value = "Valuation Status", example = "true")
	@JsonProperty(value = "valuationStatus")
	private Boolean valuationStatus;


	@ApiModelProperty(required = false,value = "Message", example = "1")
	@JsonProperty(value = "message")
	private MessageDTO messageDTO;
	
	@ApiModelProperty(required = true, value = "Customer date", example = "2000-01-01 01:01:01")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonProperty(value = "date")
	private LocalDateTime customerDate;

}
