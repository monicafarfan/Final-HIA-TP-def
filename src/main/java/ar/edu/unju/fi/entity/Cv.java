package ar.edu.unju.fi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Cvs")
@Component
public class Cv implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4307033622333899128L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "codigo")
	private int codigo;
	@Column(name = "nombre")
	private String nombre = null;
	@Column(name = "apellido")
	private String apellido = null;
	@Column(name = "contacto")
	private String contacto = null;
	@Column(name = "educacion")
	private String educacion = null;
	@Column(name = "idiomas")
	private String idiomas = null;
	@Column(name = "conocimientosInf")
	private String conocimientosInf = null;
	@Column(name = "experienciaLab")
	private String experienciaLab = null;
	@Column(name = "infoComplementaria")
	private String infoComplementaria = null;
	@Column(name = "datosAdicionales")
	private String datosAdicionales = null;
	
	@OneToOne(mappedBy = "cv")
	private Ciudadano ciudadano;
	
	public Cv() {
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public String getEducacion() {
		return educacion;
	}
	public void setEducacion(String educacion) {
		this.educacion = educacion;
	}
	public String getIdiomas() {
		return idiomas;
	}
	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}
	public String getConocimientosInf() {
		return conocimientosInf;
	}
	public void setConocimientosInf(String conocimientosInf) {
		this.conocimientosInf = conocimientosInf;
	}
	public String getExperienciaLab() {
		return experienciaLab;
	}
	public void setExperienciaLab(String experienciaLab) {
		this.experienciaLab = experienciaLab;
	}
	public String getDatosAdicionales() {
		return datosAdicionales;
	}
	public void setDatosAdicionales(String datosAdicionales) {
		this.datosAdicionales = datosAdicionales;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Ciudadano getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

	public String getInfoComplementaria() {
		return infoComplementaria;
	}

	public void setInfoComplementaria(String infoComplementaria) {
		this.infoComplementaria = infoComplementaria;
	}
	
}
