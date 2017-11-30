package com.olonte.softipac.servicio;

import com.olonte.softipac.modelo.Afinidad;

public interface AfinidadServicio {
	void guardarAfinidad(Afinidad afinidad);
	Iterable<Afinidad> buscarPorIdPaciente(Integer idPaciente);
}
