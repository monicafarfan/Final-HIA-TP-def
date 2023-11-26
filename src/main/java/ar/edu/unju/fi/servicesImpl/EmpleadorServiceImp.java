package ar.edu.unju.fi.servicesImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.repository.EmpleadorRepository;
import ar.edu.unju.fi.services.IEmpleadorService;

@Service
public class EmpleadorServiceImp implements IEmpleadorService {

	@Autowired
	private EmpleadorRepository empleadorRepo;
	
	private static final Log LOGGER = LogFactory.getLog(EmpleadorServiceImp.class);
	
	@Override
	public Empleador getEmpleador() {
		return new Empleador();
	}

	@Override
	public boolean saveEmpleador(Empleador empleador) {
		if(empleadorRepo.findByCuit(empleador.getCuit()) != null) {
			LOGGER.info("Ya existe un usuario con ese CUIT registrado");
			return false;
		}
		try {
			if(empleadorRepo.save(empleador)!=null) {
				LOGGER.info("Se ha creado un nuevo empleador");
				return true;
			} else {
				LOGGER.info("Hubo un error al crear el nuevo empleador");
				return false;
			}
		} catch (Exception e) {
			LOGGER.info("Hubo un error al crear el nuevo empleador");
			return false;
		}
	}

	@Override
	public void setSesionIn(Empleador empleador) {
		if(empleador!=null) {
			empleador.setEstado(true);
			empleadorRepo.save(empleador);
			LOGGER.info("Se ha iniciado sesion para el CUIT: "+empleador.getCuit());
		}
	}

	@Override
	public void setSesionOut(Empleador empleador) {
		if(empleador!=null) {
			empleador.setEstado(false);
			empleadorRepo.save(empleador);
			LOGGER.info("Se ha cerrado sesion para el CUIT: "+empleador.getCuit());
		}
	}

	@Override
	public boolean modifyPerfilE(Empleador empleador) {
		Empleador e = empleadorRepo.findByEstado(true);
		if(e != null) {
			try {
				e.setDescripcion(empleador.getDescripcion());
				e.setDomicilio(empleador.getDomicilio());
				e.setNombre(empleador.getNombre());
				e.setPagina(empleador.getPagina());
				e.setTelefono(empleador.getTelefono());
				e.setRazon(empleador.getRazon());
				empleadorRepo.save(e);
				LOGGER.info("Se ha modificado el usuario con CUIT: "+e.getCuit());
				return true;
			} catch (Exception ex) {
				LOGGER.info("Hubo un error al modificar el usuario con CUIT: "+e.getCuit());
				return false;
			}
		}
		LOGGER.info("No se ha encontrado el empleador");
		return false;
	}

	@Override
	public void deleteEmpleador(int codigo) {
		try {
			if(empleadorRepo.deleteEmpleadorByCodigo(codigo)) {
				LOGGER.info("Se ha eliminado el empleador con el Codigo: "+codigo);
			} else {
				LOGGER.info("No se ha encontrado el empleador con el Codigo: "+codigo);
			}
		} catch (Exception e) {
			LOGGER.info("Hubo un error al eliminar el empleador con el Codigo: "+codigo);
		}
	}

	@Override
	public Empleador findByEstado(boolean estado) {
		return empleadorRepo.findByEstado(estado);
	}

	@Override
	public Empleador findByCuitAndContrasenia(long cuit, String contrasenia) {
		return empleadorRepo.findByCuitAndContrasenia(cuit, contrasenia);
	}

	@Override
	public Empleador findByCuit(long cuit) {
		return empleadorRepo.findByCuit(cuit);
	}

}
