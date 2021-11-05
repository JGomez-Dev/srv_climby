package com.climbtogether.climby.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
@Table(name = "tb_school")
public class School implements Serializable {

	private static final long serialVersionUID = 2351451415512875940L;
	
	@Id
	@Column(name = "id_school",unique = true, nullable = false)
	private String id;
	
	@Column(name = "name_school", unique = true, nullable = false, length = 50)
	private String name;
	
}
