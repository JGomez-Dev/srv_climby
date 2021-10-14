package com.climbtogether.climby.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatusDTO implements Serializable {
	
	private static final long serialVersionUID = -1168005760903904233L;
	
	@ApiModelProperty(value = "Estado de la reserva", example = "true")
	private Boolean reservationStatus;
	
	@ApiModelProperty(value = "Estado de la valoracion", example = "true")
	private Boolean valuationStatus;

}
