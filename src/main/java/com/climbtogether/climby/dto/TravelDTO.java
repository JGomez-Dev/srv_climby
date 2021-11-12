package com.climbtogether.climby.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.PastOrPresent;

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
public class TravelDTO   implements Serializable {

	
	private static final long serialVersionUID = 5284342065783311826L;
	
//	@ApiModelProperty(required = true, value = "Identificador del viaje", example = "1")
//	@JsonProperty(value = "Identificador del viaje")
	private Integer id;
	
	@ApiModelProperty(required = true, value = "Sitio", example = "Albarracin")
	@JsonProperty(value = "site")
	private String site;
	
	@ApiModelProperty(required = true, value = "Tipo", example = "Cuerda")
	@JsonProperty(value = "type")
	private String type;
	
	@ApiModelProperty(value = "Numero de plazas", example="3")
	@JsonProperty(value = "availablePlaces")
	private Integer availablePlaces; 
	
	@ApiModelProperty(required = true, value = "Fecha salida en numeros", example = "2000-01-01 01:01:01")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@PastOrPresent
	@JsonProperty(value = "departureDate")
	private LocalDateTime departureDate;
	
	@ApiModelProperty(value = "Province",example="1")
	@JsonProperty(value = "provinceDTO")
	private String provinceDTO;
	
	@ApiModelProperty(value = "Driver",example="1")
	@JsonProperty(value = "userDTO")
	private String userDTO;
	
	@ApiModelProperty(required = false,value = "Reservation")
	@JsonProperty(value = "reservationDTO")
	private ReservationDTO reservationDTO;
	
	
//	@ApiModelProperty(value = "Reservation")
//	@JsonProperty(value = "Reservation")
//	private List<ReservationDTO> Reservation;
	
	
	
}
