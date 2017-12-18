package com.olonte.softipac.modelo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idusuario") 
	private Integer idUsuario;
	
	@Column(name = "nombres", nullable = false)
	private String nombres;
	
	@Column(name = "primerapellido", nullable = false)
	private String primerApellido;
	
	@Column(name = "segundoapellido", nullable = true)
	private String segundoApellido;
	
	@Column(name = "nombreusuario", nullable = true)
	private String nomnbreUsuario;
	
	@Column(name = "password", nullable = true)
	private String password;
	
	@Column(name = "edad", nullable = true)
	private Integer edad;
					
	@Column(name = "meses", nullable = true)
	private String meses;
				   
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "fechanacimiento", nullable = true)
	private LocalDate fechaNacimiento;
	
	@Column(name = "lugarnacimiento")
	private String lugarNacimiento;
	
	@Column(name = "tutela", nullable = true)
	private String tutela;

	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "telefonofijo")
	private String telefonoFijo;
	
	@Column(name = "telefonocelular")
	private String telefonoCelular;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "ocupacion")
	private String ocupacion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tipousuario_idtipousuario", referencedColumnName = "idtipousuario", nullable = false)
	private TipoUsuario tipoUsuario;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "documento_iddocumento", referencedColumnName = "iddocumento")
	private Documento documento;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "genero_idgenero", referencedColumnName = "idgenero", nullable = true)
	private Genero genero;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "escolaridad_idescolaridad", referencedColumnName = "idescolaridad", nullable = true)
	private Escolaridad escolaridad;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "eps_ideps", referencedColumnName = "ideps", nullable = true)
	private Eps eps;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "estado_idestado", referencedColumnName = "idestado", nullable = true)
	private Estado estado;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parentesco_idparentesco", referencedColumnName = "idparentesco", nullable = true)
	private Parentesco parentesco;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "registrodiagnostico",
			joinColumns = {
					@JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
					},
			inverseJoinColumns = {
					@JoinColumn(name = "diagnostico_iddiagnostico", referencedColumnName = "iddiagnostico")
					}
	)
	private Set<Diagnostico> diagnosticos = new HashSet<Diagnostico>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "citaUsuarioId.usuario_idusuapl", cascade = CascadeType.ALL)
	private Set<Cita> usuario_idusuapl = new HashSet<Cita>(0);
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "serviciosalud_idserviciosalud", referencedColumnName = "idserviciosalud", nullable = true)
	private ServicioSalud servicioSalud;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "perfil",
			joinColumns = {
					@JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
					},
			inverseJoinColumns = {
					@JoinColumn(name = "rol_idrol", referencedColumnName = "idrol")
					}
	)
	private Set<Rol> roles = new HashSet<Rol>(0);
	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "afinidadUsuarioId.usuario_idusuario", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Afinidad> usuario_idusuario = new HashSet<Afinidad>(0);
	
	public Usuario() {
	}
	
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	
	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	
	public String getNomnbreUsuario() {
		return nomnbreUsuario;
	}

	public void setNomnbreUsuario(String nomnbreUsuario) {
		this.nomnbreUsuario = nomnbreUsuario;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	public String getMeses() {
		return meses;
	}

	public void setMeses(String meses) {
		this.meses = meses;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getLugarNacimiento() {
		return lugarNacimiento;
	}

	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}
	
	public String getTutela() {
		return tutela;
	}

	public void setTutela(String tutela) {
		this.tutela = tutela;
	}
	
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}
	
	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	public Escolaridad getEscolaridad() {
		return escolaridad;
	}

	public void setEscolaridad(Escolaridad escolaridad) {
		this.escolaridad = escolaridad;
	}
	
	public Eps getEps() {
		return eps;
	}

	public void setEps(Eps eps) {
		this.eps = eps;
	}
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public Parentesco getParentesco() {
		return parentesco;
	}

	public void setParentesco(Parentesco parentesco) {
		this.parentesco = parentesco;
	}
	
	public Set<Diagnostico> getDiagnosticos() {
		return diagnosticos;
	}

	public void setDiagnosticos(Set<Diagnostico> diagnosticos) {
		this.diagnosticos = diagnosticos;
	}
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}
	
	public String getTelefonoCelular() {
		return telefonoCelular;
	}

	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}
	
	public Set<Afinidad> getUsuario_idusuario() {
		return usuario_idusuario;
	}

	public void setUsuario_idusuario(Set<Afinidad> usuario_idusuario) {
		this.usuario_idusuario = usuario_idusuario;
	}
	
	public Set<Rol> getRoles() {
		return roles;
	}
													
	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}
	
	public Set<Cita> getUsuario_idusuapl() {
		return usuario_idusuapl;
	}

	public void setUsuario_idusuapl(Set<Cita> usuario_idusuapl) {
		this.usuario_idusuapl = usuario_idusuapl;
	}
	
	
	public ServicioSalud getServicioSalud() {
		return servicioSalud;
	}

	public void setServicioSalud(ServicioSalud servicioSalud) {
		this.servicioSalud = servicioSalud;
	}
	
}
