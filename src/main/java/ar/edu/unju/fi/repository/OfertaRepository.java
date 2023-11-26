package ar.edu.unju.fi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Oferta;

@Repository
public interface OfertaRepository extends JpaRepository<Oferta,Long>{

	public Oferta findByCodigo(int codigo);
	
	public List<Oferta> findAll();
	
	public List<Oferta> findByCuit(long cuit);
	
	public List<Oferta> findByProvincia(String provincia);
	
	public List<Oferta> findByFecha(LocalDate fecha);
	
	public List<Oferta> findByVacantesGreaterThan(int vacantes);
}
