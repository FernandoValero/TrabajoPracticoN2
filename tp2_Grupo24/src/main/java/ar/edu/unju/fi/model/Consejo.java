package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

/**
 * Clase que representa un consejo.
 */
@Component
public class Consejo {
    private String titulo;
    private String descripcion;
    private String imagen;

    /**
     * Constructor por defecto de la clase Consejo.
     */
    public Consejo() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor de la clase Consejo que recibe el título, la descripción y la imagen.
     *
     * @param titulo      el título del consejo.
     * @param descripcion la descripción del consejo.
     * @param imagen      la imagen asociada al consejo.
     */
    public Consejo(String titulo, String descripcion, String imagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
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
}
