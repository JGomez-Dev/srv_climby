package clasesviajespublicados;

import java.util.Date;
import java.util.List;

import com.climbtogether.app.entity.Usuario;

public class ViajePublicado implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -892255538828618865L;
	//Atributos de ViajePublicado:
	private Usuario usuario;
	private Integer idviaje;
	private String lugar;
	private int numplazasdisponibles;
	private Date fechasalida;
	//Atributos UsuarioPublicado:
	private List<Pasajero> pasajerosList;
	//Constructor:
	public ViajePublicado( Integer idviaje, Usuario usuario, String lugar,  int numplazasdisponibles, Date fechasalida, List<Pasajero> pasajerosList) {
		this.idviaje = idviaje;
		this.usuario = usuario;
		this.lugar = lugar;
		this.numplazasdisponibles = numplazasdisponibles;
		this.fechasalida = fechasalida;
		this.pasajerosList = pasajerosList;
	}
	//Metodos Getter y Setters:
	public Integer getIdviaje() {
		return idviaje;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public void setIdviaje(Integer idviaje) {
		this.idviaje = idviaje;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public int getNumplazasdisponibles() {
		return numplazasdisponibles;
	}

	public void setNumplazasdisponibles(int numplazasdisponibles) {
		this.numplazasdisponibles = numplazasdisponibles;
	}

	public Date getFechasalida() {
		return fechasalida;
	}

	public void setFechasalida(Date fechasalida) {
		this.fechasalida = fechasalida;
	}


	public List<Pasajero> getPasajeroList() {
		return pasajerosList;
	}

	public void setPasajerosList(List<Pasajero> pasajerosList) {
		this.pasajerosList = pasajerosList;
	}
}