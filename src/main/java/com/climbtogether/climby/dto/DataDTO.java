package com.climbtogether.climby.dto;

import java.io.Serializable;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataDTO<D extends Serializable> implements Serializable {

	private static final long serialVersionUID = 9119060910585061267L;
	@ApiModelProperty(required = true)
	@NotNull
	private D data;
}
