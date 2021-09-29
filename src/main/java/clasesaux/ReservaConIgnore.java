package clasesaux;
//Generated 28-may-2020 20:41:23 by Hibernate Tools 5.2.12.Final

import java.util.Date;

import com.climbtogether.app.entity.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ReservaConIgnore implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7960841923005320919L;
	private ReservaId id;
	private Usuario usuario;
	private Viaje viaje;
	private Date fechareserva;

	public ReservaConIgnore() {
	}

	public ReservaConIgnore(ReservaId id, Usuario usuario, Viaje viaje, Date fechareserva) {
		this.id = id;
		this.usuario = usuario;
		this.viaje = viaje;
		this.fechareserva = fechareserva;
	}

	public ReservaId getId() {
		return this.id;
	}

	public void setId(ReservaId id) {
		this.id = id;
	}
	@JsonIgnore
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@JsonIgnore
	public Viaje getViaje() {
		return this.viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}

	public Date getFechareserva() {
		return this.fechareserva;
	}

	public void setFechareserva(Date fechareserva) {
		this.fechareserva = fechareserva;
	}

}