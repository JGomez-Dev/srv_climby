package com.climbtogether.climby.dto;

import java.io.Serializable;

import javax.validation.constraints.Null;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class MessageDTO  implements Serializable {

	private static final long serialVersionUID = -8942146662831991414L;
	
	@JsonIgnore
	private Integer id_message;
	
	@ApiModelProperty(required = false, value = "Texto mensaje", example = "Ha sido un buen viaje")
	@JsonProperty(value = "text")
	private String textMessage;
	
	@ApiModelProperty(value = "Mensaje leido", example = "false")
	@JsonProperty(value = "read")
	private Boolean read;
}
