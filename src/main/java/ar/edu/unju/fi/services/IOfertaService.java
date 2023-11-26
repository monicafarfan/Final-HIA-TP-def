package ar.edu.unju.fi.services;

import java.time.LocalDate;
import java.util.List;

import ar.edu.unju.fi.entity.Oferta;

public interface IOfertaService {
	public Oferta getOferta();
	public Oferta findByCodigo(int codigo);
	public List<Oferta> findAll();
	public List<Oferta> findByCuit(long cuit);
	public List<Oferta> findByProvincia(String provincia);
	public List<Oferta> findByFecha(LocalDate fecha);
	public boolean saveOferta(Oferta oferta);
	public List<Oferta> findByVacantesGreaterThan(int vacantes);
	public boolean modifyOferta(Oferta oferta);
}
