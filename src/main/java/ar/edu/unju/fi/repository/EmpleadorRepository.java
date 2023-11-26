package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Empleador;

@Repository
public interface EmpleadorRepository extends JpaRepository<Empleador,Long> {

	
	public List<Empleador> findAll();
	
	@Query("delete from Empleador e where e.codigo = ?1")
	public boolean deleteEmpleadorByCodigo(int codigo);
	
	@Query("select e from Empleador e where e.email = ?1")
	public Empleador findByEmail(String email);
	
	public Empleador findByCuit(long cuit);
	
	@Query("select e from Empleador e where e.cuit = ?1 and e.contrasenia = ?2")
	public Empleador findByCuitAndContrasenia(long cuit, String contrasenia);
	
	@Query("select e from Empleador e where e.estado = ?1")
	public Empleador findByEstado(boolean estado);
}
