package com.climbtogether.climby.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.PastOrPresent;

import com.climbtogether.climby.domain.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

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
	
	//@ApiModelProperty(required = true, value = "Id reservation", example = "1")
	private Integer id;
	
	@ApiModelProperty(value = "User", example = "1")
	@JsonProperty(value = "userId")
	private UserDTO userDTO;
	
	@ApiModelProperty(value = "Travel", example = "1")
	@JsonProperty(value = "idTravel")
	private Integer travelDTO;
	
	@ApiModelProperty(value = "Reservation Status", example = "true")
	@JsonProperty(value = "reservationStatus")
	private Boolean reservationStatus;
	
	@ApiModelProperty(value = "Valuation Status", example = "true")
	@JsonProperty(value = "valuationStatus")
	private Boolean valuationStatus;
	
	@ApiModelProperty(required = true, value = "Customer date" , example = "2000-01-01 01:01:01")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@PastOrPresent
	@JsonProperty(value = "date")
	private LocalDateTime customerDate;

}