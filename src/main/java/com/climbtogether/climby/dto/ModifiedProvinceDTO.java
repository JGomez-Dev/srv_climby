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
public class ModifiedProvinceDTO implements Serializable {
	
	
	private static final long serialVersionUID = 1639509619085284685L;

	@ApiModelProperty(required = true, value = "Id provincia", example = "1")
	private String id;
	
	@ApiModelProperty(required = true, value = "Nombre provincia", example = "Teruel")
	private String name;
	
	
}
