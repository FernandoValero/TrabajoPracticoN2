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
/*
 * Define a la clase Consejo como una entidad
 */

@Table(name="consejos")
/*
 * Asigna el nombre "consejos" a una tabla
 */
public class Consejo {
	@Id
	/*
	 * Indica la clave principal de la entidad
	 */
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	/*
	 * Genera el ID automaticamente
	 */
	@Column(name="id_consejo")
	/*
	 * La anotacion @Column se usa para asignar un nombre a la columna de la BD
	 */
	private Long id;
	
	@Column(name="titulo_consejo")
	@NotEmpty(message="*Debe de Agregar el titulo")
	@Size(min=4,message="*Titulo muy corto")
    private String titulo;
	
	@Column(name="descripcion_consejo")
	@NotEmpty(message="*Debe de Agregar descripcion")
	@Size(min=4,message="*Descripcion muy corta")
    private String descripcion;
    
	@Column(name="imagen_consejo")
    private String imagen;
	
	@Column(name="estado_consejo")
	private boolean estado;

    /**
     * Constructor por defecto de la clase Consejo.
     */
    public Consejo() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor de la clase Consejo que recibe el título, la descripción y la imagen.
     * 
     * @param id identificador del consejo.
     * @param titulo      el título del consejo.
     * @param descripcion la descripción del consejo.
     * @param imagen      la imagen asociada al consejo.
     * @param estado estado del consejo.
     */
    public Consejo(Long id, String titulo, String descripcion, String imagen, boolean estado) {
    	this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.estado = estado;
    }
    
    /**
	 * Permite la salida del ID 
	 * @return retorna el ID del consejo
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
     * Obtiene el título del consejo.
     *
     * @return el título del consejo.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del consejo.
     *
     * @param titulo el título del consejo a establecer.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene la descripción del consejo.
     *
     * @return la descripción del consejo.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del consejo.
     *
     * @param descripcion la descripción del consejo a establecer.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la imagen asociada al consejo.
     *
     * @return la imagen asociada al consejo.
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Establece la imagen asociada al consejo.
     *
     * @param imagen la imagen asociada al consejo a establecer.
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
	/**
	 * Permite la salida del estado
	 * @return retorna el estado del consejo
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
