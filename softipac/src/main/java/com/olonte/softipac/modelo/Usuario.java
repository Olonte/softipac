package com.olonte.softipac.modelo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	@Column(name = "tutela", nullable = true)
	private String tutela;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "fechanacimiento", nullable = true)
	private LocalDate fechaNacimiento;
	
	@Column(name = "lugarnacimiento")
	private String lugarNacimiento;
	
	@ManyToOne
	@JoinColumn(name = "tipousuario_idtipousuario", nullable = false)
	private TipoUsuario tipoUsuario;
	
	@OneToOne(mappedBy = "usuario")
	private Documento documento;
	
	@ManyToOne
	@JoinColumn(name = "genero_idgenero", nullable = true)
	private Genero genero;
	
	@ManyToOne
	@JoinColumn(name = "escolaridad_idescolaridad", nullable = true)
	private Escolaridad escolaridad;
	
	@ManyToOne
	@JoinColumn(name = "eps_ideps", nullable = true)
	private Eps eps;
	
	@ManyToOne
	@JoinColumn(name = "estado_idestado", nullable = true)
	private Estado estado;
	
	@ManyToOne
	@JoinColumn(name = "parentesco_idparentesco", nullable = true)
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
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "perfil",
			joinColumns = {
					@JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
					},
			inverseJoinColumns = {
					@JoinColumn(name = "rol_idrol", referencedColumnName = "idrol")
					}
	)
	private Set<Rol> roles = new HashSet<Rol>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "afinidad",
			joinColumns = {
					@JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
					},
			inverseJoinColumns = {
					@JoinColumn(name = "idfamiliar", referencedColumnName = "idusuario")
					}
	)
	private Set<Usuario> afinidadUsuarios = new HashSet<Usuario>();
	
	@OneToMany
	@JoinColumn(name = "")
	private Set<Cita> citas = new HashSet<Cita>();

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

	public String getTutela() {
		return tutela;
	}

	public void setTutela(String tutela) {
		this.tutela = tutela;
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

	public Set<Usuario> getAfinidadUsuarios() {
		return afinidadUsuarios;
	}

	public void setAfinidadUsuarios(Set<Usuario> afinidadUsuarios) {
		this.afinidadUsuarios = afinidadUsuarios;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

	public Set<Cita> getCitas() {
		return citas;
	}

	public void setCitas(Set<Cita> citas) {
		this.citas = citas;
	}
	

}
