package ar.edu.unju.fi.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "ofertas")
@Component
public class Oferta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8516518150099619127L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "ofe_codigo")
	private int codigo;
	@Column(name = "vacantes")
	@Min(value=1, message="Debe ser mayor a 0")
	private int vacantes;
	@Column(name = "puesto")
	@NotBlank(message = "No puede estar vacio")
	private String puesto;
	@Column(name = "disponibilidad")
	@NotBlank(message = "No puede estar vacio")
	private String disponibilidad;
	@Column(name = "tareas")
	@NotBlank(message = "No puede estar vacio")
	private String tareas;
	@Column(name = "contacto")
	@NotBlank(message = "No puede estar vacio")
	private String contacto;
	@Column(name = "jornada")
	@NotBlank(message = "No puede estar vacio")
	private String jornada;
	@Column(name = "requisitos")
	@NotBlank(message = "No puede estar vacio")
	private String requisitos;
	@Column(name = "salario")
	@Min(value = 1, message = "Debe ser mayor a 0")
	private int salario;
	@Column(name = "beneficios")
	@NotBlank(message = "No puede estar vacio")
	private String beneficios;
	@Column(name = "disponible")
	private boolean disponible = isDisponible();
	@Column(name = "fecha")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha = LocalDate.now();
	@Column(name = "provincia")
	private String provincia;
	@Column(name = "cuit")
	private long cuit;
	
	@ManyToMany(mappedBy = "aceptados")
	private List<Ciudadano> aceptados;
	
	//-----OFERTA A EMPLEADOR
	@ManyToOne
	@JoinColumn(name = "emp_codigo")
	private Empleador empleador;
	
	//-----CIUDADANO A OFERTAS----- IMPLICA QUE UNA OFERTA PUEDE TENER VARIOS CIUDADANOS POSTULADOS
	@ManyToMany(mappedBy = "ofertas")
	private Set<Ciudadano> postulantes;
	
	public Oferta() {
	}
	public int getVacantes() {
		return vacantes;
	}
	public void setVacantes(int vacantes) {
		this.vacantes = vacantes;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public String getTareas() {
		return tareas;
	}
	public void setTareas(String tareas) {
		this.tareas = tareas;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public String getJornada() {
		return jornada;
	}
	public void setJornada(String jornada) {
		this.jornada = jornada;
	}
	public String getRequisitos() {
		return requisitos;
	}
	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	public String getBeneficios() {
		return beneficios;
	}
	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}
	public boolean isDisponible() {
		return (vacantes > 0);
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Set<Ciudadano> getPostulantes() {
		return postulantes;
	}
	public void setPostulantes(Set<Ciudadano> postulantes) {
		this.postulantes = postulantes;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public long getCuit() {
		return cuit;
	}
	public void setCuit(long cuit) {
		this.cuit = cuit;
	}
	public Empleador getEmpleador() {
		return empleador;
	}
	public void setEmpleador(Empleador empleador) {
		this.empleador = empleador;
	}
	public List<Ciudadano> getAceptados() {
		return aceptados;
	}
	public void setAceptados(List<Ciudadano> aceptados) {
		this.aceptados = aceptados;
	}
	
	
}
