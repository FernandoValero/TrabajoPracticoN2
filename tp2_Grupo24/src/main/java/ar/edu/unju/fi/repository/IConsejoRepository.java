package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Consejo;
@Repository
public interface IConsejoRepository extends CrudRepository<Consejo,Long>{

	public List<Consejo> findByEstado(boolean estado);
	
}