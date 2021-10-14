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
public class ConsultationProvinceResponseDTO implements Serializable {

	
	private static final long serialVersionUID = -7913428388347401365L;
	
	@ApiModelProperty(required = true, value = "Id provincia", example = "1")
	private String id;
	
	@ApiModelProperty(required = true, value = "Nombre provincia", example = "Teruel")
	private String name;
	
}
