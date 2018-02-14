package com.olonte.softipac.convertidor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.olonte.softipac.modelo.Rol;
import com.olonte.softipac.servicio.RolServicio;

@Component
public class RegistroRolUsuario implements Converter<Object, Rol> {
	
	private RolServicio rolServicio;

	@Autowired
	public RegistroRolUsuario(RolServicio rolServicio) {
		this.rolServicio = rolServicio;
	}

	@Override
	public Rol convert(Object source) {
		return this.rolServicio.buscarPorId(Integer.parseInt((String) source));
	}

}
