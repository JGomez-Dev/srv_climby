package clasesviajespublicados;

public class Pasajero implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1349824064202195102L;
	//Atributos:
	private Integer idusuario;
	private String nombre;
	private Integer telefono;
	private String email;
	private String fotousuario;
	//Constructor:
	public Pasajero(Integer idusuario, String nombre,  Integer telefono, String email, String fotousuario) {
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.fotousuario = fotousuario;
	}
	//Metodos Getter y Setters:
	public Integer getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFotousuario() {
		return fotousuario;
	}
	public void setFotousuario(String fotousuario) {
		this.fotousuario = fotousuario;
	}
}