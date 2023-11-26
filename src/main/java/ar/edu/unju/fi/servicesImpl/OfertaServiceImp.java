package ar.edu.unju.fi.servicesImpl;

import java.time.LocalDate;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.entity.Oferta;
import ar.edu.unju.fi.repository.EmpleadorRepository;
import ar.edu.unju.fi.repository.OfertaRepository;
import ar.edu.unju.fi.services.IOfertaService;

@Service
public class OfertaServiceImp implements IOfertaService {

	@Autowired
	private OfertaRepository ofertaRepo;
	
	@Autowired
	private EmpleadorRepository empleadorRepo;
	
	private static final Log LOGGER = LogFactory.getLog(OfertaServiceImp.class);
	
	@Override
	public Oferta getOferta() {
		return new Oferta();
	}

	@Override
	public Oferta findByCodigo(int codigo) {
		return ofertaRepo.findByCodigo(codigo);
	}

	@Override
	public List<Oferta> findAll() {
		return ofertaRepo.findAll();
	}

	@Override
	public List<Oferta> findByCuit(long cuit) {
		return ofertaRepo.findByCuit(cuit);
	}

	@Override
	public List<Oferta> findByProvincia(String provincia) {
		return ofertaRepo.findByProvincia(provincia);
	}

	@Override
	public List<Oferta> findByFecha(LocalDate fecha) {
		return ofertaRepo.findByFecha(fecha);
	}

	@Override
	public boolean saveOferta(Oferta oferta) {
		try {
			Empleador e = empleadorRepo.findByEstado(true);
			oferta.setCuit(e.getCuit());
			oferta.setProvincia(e.getProvincia());
			if(ofertaRepo.save(oferta)!=null) {
				e.getOfertas().add(oferta);
				LOGGER.info("Se ha creado una nueva Oferta");
				return true;
			} else {
				LOGGER.info("Hubo un error al crear la nueva Oferta");
				return false;
			}
		} catch (Exception e) {
			LOGGER.info("Hubo un error al crear la nueva Oferta");
			return false;
		}
	}

	@Override
	public boolean modifyOferta(Oferta oferta) {
		Oferta o = ofertaRepo.findByCodigo(oferta.getCodigo());
		if(o != null) {
			try {
				o.setBeneficios(oferta.getBeneficios());
				o.setContacto(oferta.getContacto());
				o.setDisponibilidad(oferta.getDisponibilidad());
				o.setDisponible(oferta.isDisponible());
				o.setJornada(oferta.getJornada());
				o.setPuesto(oferta.getPuesto());
				o.setRequisitos(oferta.getRequisitos());
				o.setSalario(oferta.getSalario());
				o.setTareas(oferta.getTareas());
				o.setVacantes(oferta.getVacantes());
				ofertaRepo.save(o);
				LOGGER.info("Se ha modificado la oferta con Codigo: "+o.getCodigo());
				return true;
			} catch (Exception ex) {
				LOGGER.info("Hubo un error al modificar la oferta con Codigo: "+oferta.getCodigo());
			}
		}
		return false;
	}

	@Override
	public List<Oferta> findByVacantesGreaterThan(int vacantes) {
		return ofertaRepo.findByVacantesGreaterThan(vacantes);
	}


}
