package ar.edu.unju.fi.lista;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Servicio;

@Component
public class ListaServicio {
		private List<Servicio> servicios;
		public ListaServicio() {
			servicios = new ArrayList<Servicio>();
			servicios.add(new Servicio("Lunes", "Juan Perez", "9 a 12 - 16 a 18"));
			servicios.add(new Servicio("Martes","Lucas Diaz", "9 a 12 - 16 a 18"));
			servicios.add(new Servicio("Jueves","Maria Gomez", "9 a 12 - 16 a 18"));
		}
		public List<Servicio> getServicios(){
			return servicios;
		}
		public void setServicios(List<Servicio> servicios) {
			this.servicios = servicios;
		
		}
		

}
