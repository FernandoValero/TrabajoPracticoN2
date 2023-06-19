package ar.edu.unju.fi.lista;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Sucursal;

 @Component
public class ListaSucursal{
	 /**
	  * Declaración de lista sucursales
	  */
	private List<Sucursal> sucursales;
	
	/**
	 * Respresenta una sucursal de la tienda
	 * @author Grupo_24
	 */

	public ListaSucursal() {
		sucursales = new ArrayList<Sucursal>();
		sucursales.add(new Sucursal(null, "SUCURSAL SALTA", "Salta", "Av. Fuente Grande N°1088","387 154 8546","Lunes a Viernes de 9 a 22hs  - Sábado y domingo 9 a 12:30hs", "PetShop1.png", true));
		sucursales.add(new Sucursal(null, "SUCURSAL CENTRAL", "Jujuy", "Av. General Belgrano N°3915", "388 499 9999", "Lunes a Viernes de 9 a 20hs - Sábado y domingo 9 a 12:30hs","PetShop2.jpg", true));
		sucursales.add(new Sucursal(null, "SUCURSAL JUJUY-PALPALÁ", "Tucuman", "Calle ledesma N°376", "388 456 4416", "Lunes a Viernes de 8 a 22hs  - Sábado y domingo 9 a 12:30hs", "PetShop3.jpeg",  true));
		sucursales.add(new Sucursal(null, "SUCURSAL CÓRDOBA", "Salta", "Av. San Martín N°5080", "351 486 9588", "Lunes a Viernes de 08 a 20hs  - Sábado y domingo 9 a 12:30hs","PetShops.jpeg",  true));
		sucursales.add(new Sucursal(null, "SUCURSAL SANTA FE", "Bs As", "Calle Alverdi N°1400", "342 147 8466", "Lunes a Viernes de 9 a 22hs  - Sábado y domingo 9 a 12:30hs", "PetShop5.png", true));
	
	}
	

	/**
	 * Permite la salida de una sucursal
	 * @return retorna las sucursales
	 */
	public List<Sucursal> getSucursales() {
		return sucursales;
	}

	
	/**
	 * Permite la entrada de una sucursal
	 */
	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}
	 
}