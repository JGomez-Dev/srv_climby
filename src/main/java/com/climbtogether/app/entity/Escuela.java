package com.climbtogether.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import static javax.persistence.GenerationType.IDENTITY;

public class Escuela implements Serializable {

	private static final long serialVersionUID = 2351451415512875940L;

	private Integer id;
	private String nombre;
	
	public Escuela() {
	}
	
	public Escuela(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "nombre", unique = true, nullable = false, length = 50)
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
