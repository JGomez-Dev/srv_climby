package com.climbtogether.climby.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Null;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_message")
public class Message implements Serializable{

	private static final long serialVersionUID = 433894867746767442L;
	
	@Id
	@SequenceGenerator(name = "idMessageSeqGenerator", sequenceName = "sc_message", allocationSize = 1)
	@GeneratedValue(generator = "idMessageSeqGenerator")
	private Integer id_message;
	
	@Column(name = "text_message", nullable = true, length = 300)
	private String textMessage;

	@Column(name = "read")
	private Boolean read;
	

}
