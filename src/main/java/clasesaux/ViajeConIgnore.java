package clasesaux;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.climbtogether.app.entity.*;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class ViajeConIgnore implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3996519589256909294L;
	private Integer id;
	private Usuario conductor;
	private String lugar;
	private String tipo;
	private int numplazasdisponibles;
	private Date fechasalida;
	private Set<Reserva> reservas = new HashSet<Reserva>(0);

	public ViajeConIgnore() {
	}

	public ViajeConIgnore(Usuario conductor,  String lugar, int numplazasdisponibles, Date fechasalida, Set<Reserva> reservas) {
		this.conductor = conductor;
		this.lugar = lugar;
		this.numplazasdisponibles = numplazasdisponibles;
		this.fechasalida = fechasalida;
		this.reservas = reservas;
	}

	public Integer getIdviaje() {
		return this.id;
	}

	public void setIdviaje(Integer id) {
		this.id = id;
	}

	@JsonIgnore
	public Usuario getConductor() {
		return this.conductor;
	}

	public void setConductor(Usuario conductor) {
		this.conductor = conductor;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getNumplazasdisponibles() {
		return this.numplazasdisponibles;
	}

	public void setNumplazasdisponibles(int numplazasdisponibles) {
		this.numplazasdisponibles = numplazasdisponibles;
	}

	public Date getFechasalida() {
		return this.fechasalida;
	}

	public void setFechasalida(Date fechasalida) {
		this.fechasalida = fechasalida;
	}


	@JsonIgnore
	public Set<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(Set<Reserva> reservas) {
		this.reservas = reservas;
	}
	

}