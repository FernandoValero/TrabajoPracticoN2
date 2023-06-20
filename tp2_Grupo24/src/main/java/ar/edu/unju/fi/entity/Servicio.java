package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/**
 * Clase que representa un servicio.
 */
@Component
@Entity
@Table (name="servicios")
public class Servicio {
	
	@Column (name="serv_dia",length = 20,nullable =false)
	@NotBlank(message="*Debe Seleccionar un Dia")
	private String dia;
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name="id_serv")
	private Long id;
	
	@Column (name="serv_paseador",length = 20,nullable =false)
	@NotEmpty(message="*Debe de Agregar el Nombre del Paseador")
	@Size(min=5, max=20,message="*Debe tener entre 5-20 caracteres")
	private String paseador;
	
	@Column (name="serv_horario",length = 30,nullable =false)
	@NotEmpty(message="*Debe de Agregar un Horario")
	@Size(min=5, max=30,message="*Debe tener entre 5-30 caracteres")
	private String horario;
	
	@Column (name="estado_servicio")
	private boolean estado;
	 /**
     * Constructor por defecto de la clase Servicio.
     */
	public Servicio() {
		// TODO Auto-generated constructor stub
	}
	 /**
     * Constructor de la clase Servicio que recibe el dia, el paseador y el horario.
     *
     * @param dia     el dia de servicio.
     * @param paseador nombre del paseador que presta servicio.
     * @param horario      horario del paseador que presta servicio.
     */
	public Servicio(String dia, String paseador, String horario) {
		
		this.dia = dia;
		this.paseador = paseador;
		this.horario = horario;
	}
	 /**
     * Obtiene el dia de servicio.
     *
     * @return el dia de servicio.
     */
	public String getDia() {
		return dia;
	}
	 /**
     * Establece el dia de servicio.
     *
     * @param dia el dia de servicio a establecer.
     */
	public void setDia(String dia) {
		this.dia = dia;
	}
	/**
     * Obtiene el nombre del paseador de servicio.
     *
     * @return paseador de servicio.
     */
	public  String getPaseador() {
		return paseador;
	}
	/**
     * Establece el paseador de servicio.
     *
     * @param descripcion la descripción del consejo a establecer.
     */
	public void setPaseador(String paseador) {
		this.paseador = paseador;
	}
	
	/**
     * Obtiene el horario asociada al servicio.
     *
     * @return el horario asociada al servicio.
     */
	public String getHorario() {
		return horario;
	}
	/**
     * Establece el horario asociada al servicio.
     *
     * @param horario el horario asociada al servicio a establecer.
     */
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	/**
	 * Permite la salida del estado
	 * @return retorna el estado del servicio
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
