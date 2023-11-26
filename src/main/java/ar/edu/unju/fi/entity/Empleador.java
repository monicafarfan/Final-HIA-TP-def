package ar.edu.unju.fi.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name="empleadores")
@Component
public class Empleador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3383147667958120938L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "emp_codigo")
	private int codigo;
	@Column(name = "cuit")
	private long cuit;
	@Column(name = "email")
	@Email(message = "Ingrese un email valido") @NotBlank(message = "Ingrese un email valido")
	private String email;
	@Column(name = "contrasenia")
	@NotBlank(message = "Ingrese una contraseña valida") @Size(min=8, max=12, message="Debe tener un minimo de 8 caracteres o un maximo de 12")
	private String contrasenia;
	@Column(name = "provincia")
	private	String provincia;
	@Column(name = "estado")
	private boolean estado = true;
	@Column(name = "razon")
	@NotBlank(message = "No puede estar vacio")
	private String razon;
	@Column(name = "nombre")
	@NotBlank(message = "No puede estar vacio")
	private String nombre;
	@Column(name = "inicio")
	@DateTimeFormat(pattern = "yyyy-MM-dd") @PastOrPresent(message = "La fecha no es correcta")
	private LocalDate fechaInicio;
	@Column(name = "domicilio")
	private String domicilio;
	@Column(name = "pagina")
	private String pagina;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "telefono")
	private String telefono;
	
	
	
	//-----EMPLEADOR A OFERTA----- IMPLICA QUE EL TIPO EMPLEADOR PUEDE PUBLICAR UNA O MAS OFERTAS Y GUARDARLAS EN UNA LISTA
	@OneToMany(mappedBy = "empleador")
	private List<Oferta> ofertas;
	
	public Empleador() {
	}
	public long getCuit() {
		return cuit;
	}
	public void setCuit(long cuit) {
		this.cuit = cuit;
	}
	public String getRazon() {
		return razon;
	}
	public void setRazon(String razon) {
		this.razon = razon;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getPagina() {
		return pagina;
	}
	public void setPagina(String pagina) {
		this.pagina = pagina;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<Oferta> getOfertas() {
		return ofertas;
	}
	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
}
