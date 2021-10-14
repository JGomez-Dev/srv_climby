package com.climbtogether.climby.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "tb_position")
public class Position implements Serializable {


	private static final long serialVersionUID = 5332957025387103713L;

	@Id
	@Column(name = "id_position",unique = true, nullable = false)
	private String id;
	
	@Column(name = "name_position", unique = true, nullable = false, length = 50)
	private String name;
	
}
