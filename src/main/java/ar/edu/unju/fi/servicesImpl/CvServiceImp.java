package ar.edu.unju.fi.servicesImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.entity.Cv;
import ar.edu.unju.fi.repository.CiudadanoRepository;
import ar.edu.unju.fi.repository.CvRepository;
import ar.edu.unju.fi.services.ICvService;

@Service
public class CvServiceImp implements ICvService {

	@Autowired
	private CvRepository cvRepo;
	
	@Autowired
	private CiudadanoRepository ciudadanoRepo;
	
	private static final Log LOGGER = LogFactory.getLog(CvServiceImp.class);
	
	@Override
	public Cv getCv() {
		return new Cv();
	}

	@Override
	public boolean saveCv(Cv cv) {
		try {
			if(cvRepo.save(cv)!=null) {
				LOGGER.info("Se ha creado un nuevo Cv");
				return true;
			} else {
				LOGGER.info("Hubo un error al crear el nuevo Cv");
				return false;
			}
		} catch (Exception e) {
			LOGGER.info("Hubo un error al crear el nuevo Cv");
			return false;
		}
	}

	@Override
	public boolean modifyCv(Cv cv) {
		Ciudadano ciudadano = ciudadanoRepo.findByEstado(true);
		if(ciudadano != null) {
			try {
				Cv c = ciudadano.getCv();
				c.setNombre(cv.getNombre());
				c.setApellido(cv.getApellido());
				c.setEducacion(cv.getEducacion());
				c.setIdiomas(cv.getIdiomas());
				c.setConocimientosInf(cv.getConocimientosInf());
				c.setContacto(cv.getContacto());
				c.setExperienciaLab(cv.getExperienciaLab());
				c.setInfoComplementaria(cv.getInfoComplementaria());
				c.setDatosAdicionales(cv.getDatosAdicionales());
				cvRepo.save(c);
				LOGGER.info("Se ha modificado el Cv del usuario con DNI: "+ciudadano.getDni());
				return true;
			} catch (Exception ex) {
				LOGGER.info("Hubo un error al modificar el Cv del usuario con DNI: "+ciudadano.getDni());
			}
		}
		return false;
	}

	@Override
	public boolean isComplete(Cv cv) {
		if(cv.getNombre()!=null & cv.getApellido() != null & cv.getConocimientosInf()!=null & cv.getContacto()!=null &
				cv.getDatosAdicionales()!=null & cv.getEducacion()!=null & cv.getExperienciaLab()!=null & cv.getIdiomas()!=null & cv.getInfoComplementaria()!=null & cv.getNombre()!=null){
			if(!cv.getNombre().isBlank() & !cv.getApellido().isBlank() & !cv.getConocimientosInf().isBlank() & !cv.getContacto().isBlank() &
				!cv.getDatosAdicionales().isBlank() & !cv.getEducacion().isBlank() & !cv.getExperienciaLab().isBlank() &
				!cv.getIdiomas().isBlank() & !cv.getInfoComplementaria().isBlank() & !cv.getNombre().isBlank()) {
				return true;
			}
		}
		return false;
	}


}
