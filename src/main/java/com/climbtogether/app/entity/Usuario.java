package com.climbtogether.app.entity;
// Generated 28-may-2020 20:41:23 by Hibernate Tools 5.2.12.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name = "usuarios", uniqueConstraints = { @UniqueConstraint(columnNames = "idusuario"),
		@UniqueConstraint(columnNames = "telefono") })
public class Usuario implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2263533700835993208L;
	private Integer idusuario;
	private String nombreCompleto;
	private int experiencia;
	private Boolean espasajero;
	private Boolean esconductor;
	private Integer telefono;
	private String email;
	private double puntuacion;
	private Integer salidas;
	private String fotousuario;
	private Set<Reserva> reservas = new HashSet<Reserva>(0);
	private Set<Viaje> viajes = new HashSet<Viaje>(0);

	public Usuario() {
	}

	public Usuario(String nombreCompleto, int experiencia, Boolean espasajero, Boolean esconductor, Integer telefono,
			String email, double puntuacion, Integer salidas, String clave, Date fechanacimiento, String fotousuario, String descripcion,
			Set<Reserva> reservas, Set<Viaje> viajes) {
		this.nombreCompleto = nombreCompleto;
		this.experiencia = experiencia;
		this.espasajero = espasajero;
		this.esconductor = esconductor;
		this.telefono = telefono;
		this.email = email;
		this.puntuacion = puntuacion;
		this.salidas = salidas;
		this.fotousuario = fotousuario;
		this.reservas = reservas;
		this.viajes = viajes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idusuario", unique = true, nullable = false)
	public Integer getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	@Column(name = "nombrecompleto", nullable = false, length = 50)
	public String getNombreCompleto() {
		return this.nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	@Column(name = "experiencia")
	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	@Column(name = "espasajero")
	public Boolean getEspasajero() {
		return this.espasajero;
	}

	public void setEspasajero(Boolean espasajero) {
		this.espasajero = espasajero;
	}

	@Column(name = "esconductor")
	public Boolean getEsconductor() {
		return this.esconductor;
	}

	public void setEsconductor(Boolean esconductor) {
		this.esconductor = esconductor;
	}

	@Column(name = "telefono", unique = true)
	public Integer getTelefono() {
		return this.telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	@Column(name = "email", unique = true, nullable = false, length = 30)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "puntuacion")
	public double getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	@Column(name = "salidas")
	public Integer getSalidas() {
		return salidas;
	}

	public void setSalidas(Integer salidas) {
		this.salidas = salidas;
	}

	@Column(name = "fotousuario", nullable = false, length = 500)
	public String getFotousuario() {
		return this.fotousuario;
	}

	public void setFotousuario(String fotousuario) {
		this.fotousuario = fotousuario;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pasajero")
	public Set<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(Set<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "conductor")
	public Set<Viaje> getViajes() {
		return this.viajes;
	}

	public void setViajes(Set<Viaje> viajes) {
		this.viajes = viajes;
	}


}