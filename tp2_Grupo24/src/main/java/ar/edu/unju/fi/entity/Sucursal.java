package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name="sucursales")
public class Sucursal {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_sucursal")
	private Long id;
	
	@Column(name="nombre_sucursal")
	@NotEmpty(message="*Nombre vacío")
	@Size(min=4,message="*Nombre muy corto")
	private String nombre;
	
	@Column(name="provincia_sucursal")
	@NotEmpty(message="*Provincia vacía")
	@Size(min=3,message="*Nombre de Provincia muy corto")
	private String provincia;
	
	@Column(name="direccion_sucursal")
	@NotEmpty(message="*Dirección vacía")
	@Size(min=5,message="*Dirección muy corta")
	private String direccion;
	
	@Column(name="telefono_sucursal")
	@NotEmpty(message="*Teléfono vacío")
	@Size(min=4,message="*Teléfono muy corto")
	private String telefono;
	
	@Column(name="horario_sucursal")
	@NotEmpty(message="*Horario vacío")
	@Size(min=4,message="*Horario muy corto")
	private String horario;
	
	@Column(name="imagen_sucursal")
	private String imagen;
	
	@Column(name="estado_sucursal")
	private boolean estado;
	
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
	public Sucursal(Long id, String nombre, String provincia, String direccion, String telefono, String horario,String imagen, boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.provincia = provincia;
		this.direccion = direccion;
		this.telefono = telefono;
		this.horario = horario;
		this.imagen = imagen;
		this.estado = estado;
	}
	
	
	/**
	 * Permite la salida del ID 
	 * @return retorna el ID de la sucursal
	 */
	public Long getId() {
		return id;
	}
	/**
	 * Permite la entrada del atributo ID
	 * @param id, valor a asignar al ID del objeto
	 */
	public void setid(Long id) {
		this.id = id;
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
	 * Permite la salida de la provincia
	 * @return retorna la provincia de la sucursal
	 */
	public String getProvincia() {
		return provincia;
	}
	/**
	 * Permite la entrada del atributo provincia
	 * @param provincia, valor a asignar a la provincia del objeto
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
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
	 * Permite la salida del horario
	 @return retorna el Horario de la sucursal
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
	 * Permite la salida de la imagen
	 @return retorna la imagen de la sucursal
	 */
	public String getImagen() {
		return imagen;
	}
	/**
	 * Permite la entrada del atributo imagen
	 * @param nombre, imagen a asignar a la sucursal
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	
	/**
	 * Permite la salida del estado
	 * @return retorna el estado de la sucursal
	 */
	public boolean getEstado() {
		return estado;
	}
	/**
	 * Permite la entrada del atributo estado
	 * @param estado, valor a asignar al  estado del objeto
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}