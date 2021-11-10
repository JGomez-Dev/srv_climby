package com.climbtogether.climby.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

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
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1076577097267741731L;
	
//	@ApiModelProperty(required = true, value = "Identificador usuario", example = "1")
//	@NotNull
	private Integer id;
	
	@ApiModelProperty(required = true, value = "Nombre completo", example = "Eduardo Gomez")
	private String fullName;
	
	@ApiModelProperty(value = "Experiencia", example="5")
	private Integer experience; 
	
//	@ApiModelProperty(value = "Posicion", example = "1")
//	private Integer position;

	@ApiModelProperty(required = true, value = "Telefono", example = "691675453")
	private String phone;
	
	@ApiModelProperty(required = true, value = "Email", example = "edu21061991@gmail.com")
	private String email;
	
	@ApiModelProperty(required = true, value = "Puntuacion", example = "8")
	private BigDecimal score;
	

	@ApiModelProperty(value = "Salidas", example="5")
	private Integer outputs; 
	
	@ApiModelProperty(required = true, value = "Foto", example = "7")
	private String userPhoto;

//	@ApiModelProperty(value = "Reservation")
//	@JsonProperty(value = "Reservation")
//	private List<ReservationDTO> reservationDTO;
//	
//	@ApiModelProperty(value = "Travel")
//	@JsonProperty(value = "Travel")
//	private List<TravelDTO> travelDTO;
	
	
	
	
}
