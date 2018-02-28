package com.olonte.softipac.modelo;

public class HistoriaClinicaForma {
	
	private HistoriaClinica historiaClinica;
	
	private Usuario paciente;
	
	private Usuario padre;
	
	private Usuario madre;

	public HistoriaClinicaForma() {
	}

	public HistoriaClinica getHistoriaClinica() {
		return historiaClinica;
	}

	public void setHistoriaClinica(HistoriaClinica historiaClinica) {
		this.historiaClinica = historiaClinica;
	}

	public Usuario getPaciente() {
		return paciente;
	}

	public void setPaciente(Usuario paciente) {
		this.paciente = paciente;
	}

	public Usuario getPadre() {
		return padre;
	}

	public void setPadre(Usuario padre) {
		this.padre = padre;
	}

	public Usuario getMadre() {
		return madre;
	}

	public void setMadre(Usuario madre) {
		this.madre = madre;
	}


}
