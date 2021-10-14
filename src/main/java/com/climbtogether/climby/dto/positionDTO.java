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
public class positionDTO implements Serializable {

	private static final long serialVersionUID = -9008106369861307152L;
	
	@ApiModelProperty(required = true, value = "Id posicion", example = "1")
	private String id;
	
	@ApiModelProperty(required = true, value = "Nombre posicion", example = "Conductor")
	private String name;

}
