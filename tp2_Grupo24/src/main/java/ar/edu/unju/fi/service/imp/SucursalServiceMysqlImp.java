package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.repository.ISucursalRepository;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

@Service("sucursalServiceMysql")
public class SucursalServiceMysqlImp implements ISucursalService {

	@Autowired
	private ISucursalRepository sucursalRepository;
	
	@Autowired
	private Sucursal sucursal;
	
	@Override
	public List<Sucursal> getListaSucursal() {
		
		return sucursalRepository.findByEstado(true);
	}

	@Override
	public void guardar(@Valid Sucursal sucursal) {
		sucursal.setEstado(true);
		sucursalRepository.save(sucursal);

	}

	@Override
	public Sucursal getBy(Long id) {
		return sucursalRepository.findById(id).get();
	}

	@Override
	public void editar(Sucursal sucursal) {
		/*sucursal.setid(sucursal.getId());
		sucursal.setNombre(sucursal.getNombre());
		sucursal.setProvincia(sucursal.getProvincia());
		sucursal.setDireccion(sucursal.getDireccion());
		sucursal.setTelefono(sucursal.getTelefono());
		sucursal.setHorario(sucursal.getHorario());
		sucursal.setImagen(sucursal.getImagen());
		sucursal.setEstado(true);*/
		sucursalRepository.save(sucursal);
	}

	@Override
	public void eliminar(Sucursal sucursalEncontrada) {
		sucursalEncontrada.setEstado(false);
		sucursalRepository.save(sucursalEncontrada);
	}

	@Override
	public Sucursal getSucursal() {
		return sucursal;
	}

	

}
