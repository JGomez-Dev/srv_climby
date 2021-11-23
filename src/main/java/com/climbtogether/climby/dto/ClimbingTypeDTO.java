package com.climbtogether.climby.dto;

import java.io.Serializable;

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
public class ClimbingTypeDTO implements Serializable {

	private static final long serialVersionUID = -9008106369861307152L;

	@ApiModelProperty(required = true, value = "Nombre escuela", example = "Clásica")
	@NotNull
	private String name;

}
