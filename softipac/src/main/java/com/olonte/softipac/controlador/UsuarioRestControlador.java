package com.olonte.softipac.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.olonte.softipac.json.UsuarioJSON;
import com.olonte.softipac.servicio.UsuarioServicio;

@RestController
@Scope(value = "session")
public class UsuarioRestControlador {
	
	private UsuarioServicio usuarioServicio;
	
	@Autowired
	public UsuarioRestControlador(UsuarioServicio usuarioServicio) {
		this.usuarioServicio = usuarioServicio;
	}

	/**
	 * 
	 * @param documento
	 * @return
	 */
	@RequestMapping(value = "/obtenerUsuario/{parametros}", method = RequestMethod.GET)
	public UsuarioJSON obtenerUsuarioPorDocumento(@PathVariable("parametros") String parametros){
		return this.usuarioServicio.bucarPorDocumento(parametros);
	}

}
