package ar.edu.unju.fi.lista;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Servicio;

@Component
public class ListaServicio {
		private List<Servicio> servicios;
		/**
	     * Constructor de la clase ListaServicio.
	     * Inicializa la lista de servicios y agrega algunos servicios predefinidos.
	     */
		public ListaServicio() {
			servicios = new ArrayList<Servicio>();
			servicios.add(new Servicio("Lunes", "Juan Perez", "9 a 12 - 16 a 18"));
			servicios.add(new Servicio("Martes","Lucas Diaz", "9 a 12 - 16 a 18"));
			servicios.add(new Servicio("Jueves","Maria Gomez", "9 a 12 - 16 a 18"));
		}
		/**
	     * Obtiene la lista de servicios.
	     *
	     * @return la lista de servicios.
	     */
		public List<Servicio> getServicios(){
			return servicios;
		}
		/**
	     * Establece la lista de servicios.
	     *
	     * @param servicios la lista de servicios a establecer.
	     */
		public void setServicios(List<Servicio> servicios) {
			this.servicios = servicios;
		
		}
		

}
