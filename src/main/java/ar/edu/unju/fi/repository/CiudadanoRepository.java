package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Ciudadano;

@Repository
public interface CiudadanoRepository extends JpaRepository<Ciudadano,Long> {
	
	public List<Ciudadano> findAll();
	
	@Query("delete from Ciudadano c where c.codigo = ?1")
	public boolean deleteCiudadanoByCodigo(int codigo);
	
	@Query("select c from Ciudadano c where c.email = ?1")
	public Ciudadano findByEmail(String email);
	
	public Ciudadano findByDni(long dni);
	
	@Query("select c from Ciudadano c where c.dni = ?1 and c.contrasenia = ?2")
	public Ciudadano findByDniAndContrasenia(long dni, String contrasenia);
	
	@Query("select c from Ciudadano c where c.estado = ?1")
	public Ciudadano findByEstado(boolean estado);
	
	public List<Ciudadano> findByProvincia(String provincia);
}
