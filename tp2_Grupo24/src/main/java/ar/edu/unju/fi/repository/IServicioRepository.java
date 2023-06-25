package ar.edu.unju.fi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ar.edu.unju.fi.entity.Servicio;
import java.util.List;

@Repository
public interface IServicioRepository extends CrudRepository<Servicio,Long>{
	/*
	 * Método para devolver servicios de acuerdo a su estado.
	 */
	public List<Servicio> findByEstado(boolean estado);
}
