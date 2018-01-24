package com.olonte.softipac.json;

import java.util.ArrayList;
import java.util.List;

import com.olonte.softipac.modelo.Cita;
import com.olonte.softipac.modelo.Hora;

public class CitaJSON extends Cita {
	
	private List<Hora> horas = new ArrayList<Hora>(); 
	
	public CitaJSON(){
	}

	public List<Hora> getHoras() {
		return horas;
	}

	public void setHoras(List<Hora> horas) {
		this.horas = horas;
	}
	
}
