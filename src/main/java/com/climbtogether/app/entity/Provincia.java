package com.climbtogether.app.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "provincias", uniqueConstraints = { @UniqueConstraint(columnNames = "id") })
public class Provincia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3794831936889509869L;
	private Integer id;
	private String nombre;

	
	public Provincia() {
	}
	
	public Provincia(Integer id, String nombre) {
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
