package com.olonte.softipac.servicio;

import java.util.List;

import com.olonte.softipac.json.UsuarioJSON;
import com.olonte.softipac.modelo.Usuario;
import com.olonte.softipac.modelo.UsuarioForma;

public interface UsuarioServicio {
	Usuario bucarPorNombreUsuario(String nombreUsuario);
	void guardar(Usuario usuario);
	void guardar(UsuarioForma usuarioForma, Integer idEstado);
	UsuarioJSON bucarPorDocumento(String parametros);
	Usuario buscarPorId(Integer idUsuario);
	Usuario buscarPacientePorId(Integer idUsuario);
	Usuario buscarAcudientePorId(Integer idUsuario, Integer idTipoUsuario);
	Usuario buscarFamiliarPorId(Integer idUsuario, Integer idParentesco);
	List<Usuario> buscarPorIdTipoUsuario(Integer idTipoUsuarioApl, Integer idTipoUsuariSis);
	void cambiarEstadoUsuario(Integer idUsuario, Integer idEstado);
}
