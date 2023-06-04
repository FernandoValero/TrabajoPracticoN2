package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Sucursal {
	private String nombre;
	private String direccion;
	private String telefono;
	private String horario;
	private String imagen;
	
	/**
	 * Constructor de la clase Sucursal
	 */
	public Sucursal() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 *Constructor sobrecargado de la clase Sucursal
	 *@param nombre, valor a asignar al  Nombre del objeto Sucursal
	 *@param direccion, valor a asignar a la Direccion del objeto Sucursal
	 *@param telefono, valor a asignar a el Telefono del objeto Sucursal
	 *@param horario, valor a asignar al Horario del objeto Sucursal
	 *@param imagen, imagen a asignar para la sucursal
	 */
	public Sucursal(String nombre, String direccion, String telefono, String horario,String imagen) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.horario = horario;
		this.imagen = imagen;
	}
	
	
	/**
	 * Permite la salida del nombre
	 * @return retorna el Nombre de la sucursal
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Permite la entrada del atributo nombre
	 * @param nombre, valor a asignar al  Nombre del objeto
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	/**
	 * Permite la salida de la direccion
	 * @return retorna la Direccion de la sucursal
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * Permite la entrada del atributo direccion
	 * @param direccion, valor a asignar a la Direccion del objeto
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	 
	
	/**
	 * Permite la salida del telefono
	 @return retorna el Telefono de la sucursal
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * Permite la entrada del atributo telefono
	 * @param telefono, valor a asignar al Telefono del objeto
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * Permite la salida del nombre
	 @return retorna el Nombre de la sucursal
	 */
	public String getHorario() {
		return horario;
	}
	/**
	 * Permite la entrada del atributo horario
	 * @param horario, valor a asignar al  Horario del objeto
	 */
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	
	/**
	 * Permite la salida del nombre
	 @return retorna el Nombre de la sucursal
	 */
	public String getImagen() {
		return imagen;
	}
	/**
	 * Permite la entrada del atributo nombre
	 * @param nombre, valor a asignar al  Nombre del objeto
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	
	
}