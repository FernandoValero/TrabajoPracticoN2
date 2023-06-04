package ar.edu.unju.fi.lista;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Consejo;

@Component
public class ListaConsejo{
	private List<Consejo> consejos;
	
	public ListaConsejo() {
		consejos = new ArrayList<Consejo>();
		consejos.add(new Consejo("Prevención de obesidad", "La obesidad es un problema creciente en las mascotas y puede llevar a problemas graves como diabetes, enfermedades cardíacas y problemas articulares.", "obesidad-perros.jpg"));
		consejos.add(new Consejo("Detectar y tratar pulgas en los gatos", "Las pulgas son un problema común en los gatos y pueden causar irritación en la piel, alergias y anemia si no se tratan adecuadamente.", "cat.jpg"));
		consejos.add(new Consejo("Cuidados necesarios para evitar el golpe de calor en perros", "El golpe de calor es un problema grave y potencialmente mortal para los perros durante los meses más calurosos del año.", "dog.png"));
	}
	

	public List<Consejo> getConsejos() {
		return consejos;
	}

	public void setConsejos(List<Consejo> consejos) {
		this.consejos = consejos;
	}
}