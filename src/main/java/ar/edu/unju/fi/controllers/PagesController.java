package ar.edu.unju.fi.controllers;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.services.ICiudadanoService;
import ar.edu.unju.fi.services.IEmpleadorService;
import ar.edu.unju.fi.services.IOfertaService;


@Controller
@RequestMapping("/")
public class PagesController {
	
	@Autowired
	private IEmpleadorService empleadorSer;
	
	@Autowired
	private ICiudadanoService ciudadanoSer;
	
	@Autowired
	private IOfertaService ofertaSer;

	private static final Log LOGGER = LogFactory.getLog(PagesController.class);
	/*
	 * 	FRAGMENTO DE CODIGO USADO PARA CONTROLAR EL ACCESO A LAS VIEWS DEPENDIENDO DE LA SESION
	 * 
	 * Ciudadano c = ciudadanoSer.findByEstado(true);
		if(c==null) {
			ModelAndView mav = new ModelAndView("redirect:/indexC");
			mav.addObject("ciudadano", c);
			LOGGER.info("Redirigido a Iniciar Sesion...");
			return mav;
		}
		
		
		
		
		Empleador e = empleadorSer.findByEstado(true);
		if(e==null) {
			ModelAndView mav = new ModelAndView("redirect:/indexE");
			mav.addObject(e);
			LOGGER.info("Redirigido a Inicio...");
			return mav;
		}
	 */
	
	@GetMapping("/")
	public String getIndexPage() {
		Ciudadano c = ciudadanoSer.findByEstado(true);
		Empleador e = empleadorSer.findByEstado(true);
		if(c==null & e==null) {
			return "index";
		}
		return "index";
	}
	
	@GetMapping("/indexE")
	public ModelAndView getEmpleadorPage() {
		Ciudadano c = ciudadanoSer.findByEstado(true);
		if(c!=null) {
			ModelAndView mav = new ModelAndView("redirect:/indexC");
			LOGGER.info("Redirigido a Inicio...");
			return mav;
		}
		Empleador e = empleadorSer.findByEstado(true);
		if(e==null) {
			ModelAndView mav = new ModelAndView("redirect:/");
			LOGGER.info("Redirigido a Inicio...");
			return mav;
		}
		ModelAndView mav = new ModelAndView("indexE");
		LOGGER.info("Cargando ofertas de la pagina de inicio...");
		mav.addObject("ofertas", ofertaSer.findByVacantesGreaterThan(0));
		return mav;
	}
	
	@GetMapping("/indexC")
	public ModelAndView getCiudadanoPage() {
		Empleador e = empleadorSer.findByEstado(true);
		if(e!=null) {
			ModelAndView mav = new ModelAndView("redirect:/indexE");
			LOGGER.info("Redirigido a Inicio...");
			return mav;
		}
		Ciudadano c = ciudadanoSer.findByEstado(true);
		if(c==null) {
			ModelAndView mav = new ModelAndView("redirect:/");
			LOGGER.info("Redirigido a Inicio...");
			return mav;
		}
		ModelAndView mav = new ModelAndView("indexC");
		LOGGER.info("Cargando ofertas de la pagina de inicio...");
		mav.addObject("ofertas", ofertaSer.findByVacantesGreaterThan(0));
		return mav;
	}
	
	@GetMapping("/ciudadanos")
	public ModelAndView getCiudadanos() {
		Ciudadano c = ciudadanoSer.findByEstado(true);
		if(c!=null) {
			ModelAndView mav = new ModelAndView("redirect:/indexC");
			LOGGER.info("Redirigido a Inicio...");
			return mav;
		}
		Empleador e = empleadorSer.findByEstado(true);
		if(e==null) {
			ModelAndView mav = new ModelAndView("redirect:/");
			LOGGER.info("Redirigido a Inicio...");
			return mav;
		}
		ModelAndView mav = new ModelAndView("listaCiudadanos");
		LOGGER.info("Cargando ciudadanos disponibles...");
		mav.addObject("ciudadanos", ciudadanoSer.findAll());
		return mav;
	}
	
}