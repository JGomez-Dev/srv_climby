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
@Table(name = "tb_province")
public class Province implements Serializable{

	private static final long serialVersionUID = -985853124316450362L;
	
	@Id
	@Column(name = "name_province", unique = true, nullable = false, length = 50)
	private String name;
	
	
	private Integer numberTravels;

}
