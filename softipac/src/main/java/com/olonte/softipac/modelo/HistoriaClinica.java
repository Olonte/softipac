package com.olonte.softipac.modelo;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "historiaclinica")
public class HistoriaClinica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idhistoriaclinica")
	private Integer idHistoriaClinica;
	
	@Column(name = "motivoconsulta")
	private String motivoconsulta;
	
	@Column(name = "habilespeciales")
	private String habilespeciales;
	
	@Column(name = "problemascond")
	private String problemascond;
	
	@Column(name = "caractambiente")
	private String caractambiente;
	
	private Set<Afinidad> afinidades = new HashSet<Afinidad>(0);
	
	@OneToOne(mappedBy = "historiaclinica_idhistoriaclinica")
	private Remision remision;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "responsividad",
			joinColumns = {
					@JoinColumn(name = "historiaclinica_idhistoriaclinica", referencedColumnName = "")
					},
			inverseJoinColumns = {
					@JoinColumn(name = "estimulo_idestimulo", referencedColumnName = "idestimulo")
					}
	)
	private Set<Estimulo> estimulos = new HashSet<Estimulo>(0);
	
	@OneToOne(mappedBy = "historiaclinica_idhistoriaclinica")
	private ResistenciaCambio resistenciaCambio;
	
	@OneToOne(mappedBy = "historiaclinica_idhistoriaclinica")
	private RespEstimulosEnVisual respEstimulosEnVisual;
	
	@OneToOne(mappedBy = "historiaclinica_idhistoriaclinica")
	private RepertorioBasico repertorioBasico;

	public HistoriaClinica() {
	}

	public Integer getIdHistoriaClinica() {
		return idHistoriaClinica;
	}

	public void setIdHistoriaClinica(Integer idHistoriaClinica) {
		this.idHistoriaClinica = idHistoriaClinica;
	}

	public String getMotivoconsulta() {
		return motivoconsulta;
	}

	public void setMotivoconsulta(String motivoconsulta) {
		this.motivoconsulta = motivoconsulta;
	}

	public String getHabilespeciales() {
		return habilespeciales;
	}

	public void setHabilespeciales(String habilespeciales) {
		this.habilespeciales = habilespeciales;
	}

	public String getProblemascond() {
		return problemascond;
	}

	public void setProblemascond(String problemascond) {
		this.problemascond = problemascond;
	}

	public String getCaractambiente() {
		return caractambiente;
	}

	public void setCaractambiente(String caractambiente) {
		this.caractambiente = caractambiente;
	}
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "constitucionfamiliar",
			joinColumns = {
					@JoinColumn(name = "historiaclinica_idhistoriaclinica", referencedColumnName = "idhistoriaclinica")
					},
			inverseJoinColumns = {
					@JoinColumn(name = "afinidad_idafinidad", referencedColumnName = "idafinidad"),
					@JoinColumn(name = "afinidad_usuario_idusuario", referencedColumnName = "usuario_idusuario"),
					@JoinColumn(name = "afinidad_idfamiliar", referencedColumnName = "idfamiliar")
					}
	)
	public Set<Afinidad> getAfinidades() {
		return afinidades;
	}

	public void setAfinidades(Set<Afinidad> afinidades) {
		this.afinidades = afinidades;
	}
	
	public Remision getRemision() {
		return remision;
	}

	public void setRemision(Remision remision) {
		this.remision = remision;
	}

	public Set<Estimulo> getEstimulos() {
		return estimulos;
	}

	public void setEstimulos(Set<Estimulo> estimulos) {
		this.estimulos = estimulos;
	}
	
	public ResistenciaCambio getResistenciaCambio() {
		return resistenciaCambio;
	}

	public void setResistenciaCambio(ResistenciaCambio resistenciaCambio) {
		this.resistenciaCambio = resistenciaCambio;
	}
	
	public RespEstimulosEnVisual getRespEstimulosEnVisual() {
		return respEstimulosEnVisual;
	}

	public void setRespEstimulosEnVisual(RespEstimulosEnVisual respEstimulosEnVisual) {
		this.respEstimulosEnVisual = respEstimulosEnVisual;
	}
	
	public RepertorioBasico getRepertorioBasico() {
		return repertorioBasico;
	}

	public void setRepertorioBasico(RepertorioBasico repertorioBasico) {
		this.repertorioBasico = repertorioBasico;
	}
	
}
