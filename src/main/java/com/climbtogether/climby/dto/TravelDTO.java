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
	
	@ApiModelProperty(required = true, value = "Identificador del viaje", example = "1")
	private String id;
	
	@ApiModelProperty(required = true, value = "Sitio", example = "Albarracin")
	private String site;
	
	@ApiModelProperty(required = true, value = "tipo", example = "Cuerda")
	private String type;
	
	@ApiModelProperty(value = "Numero de plazas", example="3")
	private Integer availablePlaces; 
	
	@ApiModelProperty(required = true, value = "Fecha salida en numeros", example = "2000-01-01 01:01:01")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@PastOrPresent
	private LocalDateTime departureDate;
	
	@ApiModelProperty(value = "Province")
	@JsonProperty(value = "Province")
	private ProvinceDTO provinceDTO;
	
	@ApiModelProperty(value = "User")
	@JsonProperty(value = "User")
	private UserDTO userDTO;
	
//	@ApiModelProperty(value = "Reservation")
//	@JsonProperty(value = "Reservation")
//	private List<ReservationDTO> Reservation;
	
	
	
}
