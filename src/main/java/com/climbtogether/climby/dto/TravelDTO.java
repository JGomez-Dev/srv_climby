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
	@JsonProperty(value = "Sitio del viaje")
	private String site;
	
	@ApiModelProperty(required = true, value = "Tipo", example = "Cuerda")
	@JsonProperty(value = "Tipo de viaje")
	private String type;
	
	@ApiModelProperty(value = "Numero de plazas", example="3")
	@JsonProperty(value = "Numero de plazas")
	private Integer availablePlaces; 
	
	@ApiModelProperty(required = true, value = "Fecha salida en numeros", example = "2000-01-01 01:01:01")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@PastOrPresent
	@JsonProperty(value = "Fecha salida")
	private LocalDateTime departureDate;
	
	@ApiModelProperty(value = "Province",example="1")
	@JsonProperty(value = "ID-Provincia")
	private String provinceDTO;
	
	@ApiModelProperty(value = "Driver",example="1")
	@JsonProperty(value = "ID-Conductor")
	private String userDTO;
	
	@ApiModelProperty(required = false,value = "Reservation")
	@JsonProperty(value = "Informacion reserva")
	private ReservationDTO reservationDTO;
	
	
//	@ApiModelProperty(value = "Reservation")
//	@JsonProperty(value = "Reservation")
//	private List<ReservationDTO> Reservation;
	
	
	
}
