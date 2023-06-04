package ar.edu.unju.fi.lista;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import ar.edu.unju.fi.model.Sucursal;

 @Component
public class ListaSucursal{
	private List<Sucursal> sucursales;
	
	public ListaSucursal() {
		sucursales = new ArrayList<Sucursal>();
		sucursales.add(new Sucursal("SUCURSAL SALTA", "Av. Fuente Grande N°1088","387 154 8546","Lunes a Viernes de 9 a 22hs  - Sábado y domingo 9 a 12:30hs", "PetShop1.png"));
		sucursales.add(new Sucursal("SUCURSAL CENTRAL", "Av. General Belgrano N°3915", "388 499 9999", "Lunes a Viernes de 9 a 20hs - Sábado y domingo 9 a 12:30hs","PetShop2.jpg"));
		sucursales.add(new Sucursal("SUCURSAL JUJUY-PALPALÁ", "Calle ledesma N°376", "388 456 4416", "Lunes a Viernes de 8 a 22hs  - Sábado y domingo 9 a 12:30hs", "PetShop3.jpeg"));
		sucursales.add(new Sucursal("SUCURSAL CÓRDOBA", "Av. San Martín N°5080", "351 486 9588", "Lunes a Viernes de 08 a 20hs  - Sábado y domingo 9 a 12:30hs","PetShops.jpeg"));
		sucursales.add(new Sucursal("SUCURSAL SANTA FE", "Calle Alverdi N°1400", "342 147 8466", "Lunes a Viernes de 9 a 22hs  - Sábado y domingo 9 a 12:30hs", "PetShop5.png"));
	}
	

	public List<Sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}
	 
}