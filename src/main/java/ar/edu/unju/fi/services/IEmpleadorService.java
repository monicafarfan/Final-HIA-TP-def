package ar.edu.unju.fi.services;

import ar.edu.unju.fi.entity.Empleador;

public interface IEmpleadorService {

	public Empleador getEmpleador();
	public boolean saveEmpleador(Empleador empleador);
	public void setSesionIn(Empleador empleador);
	public void setSesionOut(Empleador empleador);
	public boolean modifyPerfilE(Empleador empleador);
	public void deleteEmpleador(int codigo);
	public Empleador findByCuitAndContrasenia(long cuit, String contrasenia);
	public Empleador findByEstado(boolean estado);
	public Empleador findByCuit(long cuit);
}
