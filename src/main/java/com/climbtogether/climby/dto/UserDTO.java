package com.climbtogether.climby.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1076577097267741731L;
	
	@ApiModelProperty(required = true, value = "Identificador usuario", example = "1")
//	@NotNull
	private Integer id;
	
	@ApiModelProperty(required = true, value = "Full name", example = "Eduardo Gomez")
	private String fullName;
	
	@ApiModelProperty(value = "Experience", example="5")
	private String experience; 

	@ApiModelProperty(required = true, value = "Phone", example = "691675453")
	private String phone;
	
	@ApiModelProperty(required = true, value = "Email", example = "edu21061991@gmail.com")
	private String email;
	
	@ApiModelProperty(required = true, value = "Score", example = "8")
	private BigDecimal score;

	@ApiModelProperty(value = "Outpust", example="5")
	private Integer outputs; 
	
	@ApiModelProperty(required = true, value = "Photo", example = "7")
	private String userPhoto;
	
	@ApiModelProperty(required = true, value = "Ratings", example = "0")
	private Integer ratings;
	
	@ApiModelProperty(required = true, value = "Token", example = "160")
	private String token;
	
	@ApiModelProperty(required = true, value = "Registration Date", example = "2000-01-01 01:01:01")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonProperty(value = "Registration Date")
	private LocalDateTime registrationDate;
	
	
	
	
	
}
