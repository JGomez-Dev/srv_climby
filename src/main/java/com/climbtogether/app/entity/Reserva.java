package com.climbtogether.app.entity;
// Generated 28-may-2020 20:41:23 by Hibernate Tools 5.2.12.Final

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "reservas")
public class Reserva implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9153958421322772542L;
	private ReservaId id;
	private Usuario pasajero;
	private Viaje viaje;
	private int viajeId;
	private Timestamp fechareserva;
	private byte estadoreserva;
	private byte estadovaloracion;

	public Reserva() {
	}
	
	public Reserva(ReservaId id, Usuario pasajero, Viaje viaje, String fecha_salida_string, byte estadoreserva, byte estadovaloracion) {
		this.id = id;
		this.pasajero = pasajero;
		this.viaje = viaje;
		this.estadoreserva=estadoreserva;
		this.estadovaloracion=estadovaloracion;
	}
	
	public Reserva(ReservaId id, Usuario pasajero, Viaje viaje, byte estadoreserva, byte estadovaloracion) {
		this.id = id;
		this.pasajero = pasajero;
		this.viaje = viaje;
		this.estadoreserva=estadoreserva;
		this.estadovaloracion=estadovaloracion;
	}
	
	public Reserva(ReservaId id, Usuario pasajero, Viaje viaje, Timestamp fechareserva, byte estadoreserva, byte estadovaloracion) {
		this.id = id;
		this.pasajero = pasajero;
		this.viaje = viaje;
		this.fechareserva = fechareserva;
		this.estadoreserva=estadoreserva;
		this.estadovaloracion=estadovaloracion;

	}

	public Reserva(Usuario pasajero, int viajeId) {
		this.pasajero = pasajero;
		this.viajeId = viajeId;
	}
	
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idreserva", column = @Column(name = "idreserva", nullable = false)),
			@AttributeOverride(name = "idPasajero", column = @Column(name = "idPasajero", nullable = false)),
			@AttributeOverride(name = "idviaje", column = @Column(name = "idviaje", nullable = false)) })
	public ReservaId getId() {
		return this.id;
	}

	public void setId(ReservaId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idPasajero", nullable = false, insertable = false, updatable = false)
	public Usuario getPasajero() {
		return this.pasajero;
	}

	public void setPasajero(Usuario pasajero) {
		this.pasajero = pasajero;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idviaje", nullable = false, insertable = false, updatable = false)
	public Viaje getViaje() {
		return this.viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechareserva", nullable = false, length = 19)
	public Date getFechareserva() {
		return this.fechareserva;
	}

	public void setFechareserva(Timestamp fechareserva) {
		this.fechareserva = fechareserva;
	}
	
	@JoinColumn(name = "estadoreserva", nullable = false)
	public byte getEstadoReserva() {
		return estadoreserva;
	}

	public void setEstadoReserva(byte estadoreserva) {
		this.estadoreserva = estadoreserva;
	}
	
	
	@JoinColumn(name = "estadovaloracion", nullable = false)
	public byte getEstadoValoracion() {
		return estadovaloracion;
	}

	public void setEstadoValoracion(byte estadovaloracion) {
		this.estadovaloracion = estadovaloracion;
	}
	
	@Transient
	public int getViajeId() {
		return viajeId;
	}

	public void setViajeId(int viajeId) {
		this.viajeId = viajeId;
	}
	
}