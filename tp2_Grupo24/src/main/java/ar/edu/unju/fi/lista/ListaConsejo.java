package ar.edu.unju.fi.lista;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Consejo;

@Component
public class ListaConsejo {
	/**
	  * Declaración de lista consejos
	  */
    private List<Consejo> consejos;

    /**
     * Constructor de la clase ListaConsejo.
     * Inicializa la lista de consejos y agrega algunos consejos predefinidos.
     */
    public ListaConsejo() {
        consejos = new ArrayList<Consejo>();
        consejos.add(new Consejo(null,"Prevención de obesidad", "La obesidad es un problema creciente en las mascotas y puede llevar a problemas graves como diabetes, enfermedades cardíacas y problemas articulares.", "obesidad-perros.jpg",true));
        consejos.add(new Consejo(null,"Detectar y tratar pulgas en los gatos", "Las pulgas son un problema común en los gatos y pueden causar irritación en la piel, alergias y anemia si no se tratan adecuadamente.", "cat.jpg",true));
        consejos.add(new Consejo(null,"Cuidados necesarios para evitar el golpe de calor en perros", "El golpe de calor es un problema grave y potencialmente mortal para los perros durante los meses más calurosos del año.", "dog.png",true));
    }

    /**
     * Permite la salida de un consejo.
     *
     * @return la lista de consejos.
     */
    public List<Consejo> getConsejos() {
        return consejos;
    }

    /**
     * Permite la entrada de un consejo
     */
    public void setConsejos(List<Consejo> consejos) {
        this.consejos = consejos;
    }
}
