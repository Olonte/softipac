package com.olonte.softipac.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.olonte.softipac.modelo.Usuario;
import com.olonte.softipac.modelo.UsuarioForma;
import com.olonte.softipac.modelo.UsuarioSession;
import com.olonte.softipac.servicio.EscolaridadServicio;
import com.olonte.softipac.servicio.GeneroServicio;
import com.olonte.softipac.servicio.RolServicio;
import com.olonte.softipac.servicio.TipoDocumentoServicio;
import com.olonte.softipac.servicio.TipoUsuarioServicio;
import com.olonte.softipac.servicio.UsuarioServicio;
import com.olonte.softipac.utilidad.QuickPasswordEncodingGenerator;
import com.olonte.softipac.utilidad.Utilidad;
import com.olonte.softipac.validador.ValidadorUsuario;

@Controller
@Scope(value = "session")
public class UsuarioControlador {
	
	private UsuarioSession usuarioSession;
	
	private ValidadorUsuario validadorUsuario;
	
	private UsuarioServicio usuarioServicio;
	
	private TipoDocumentoServicio tipoDocumentoServicio;
	
	private GeneroServicio generoServicio;
	
	private EscolaridadServicio escolaridadServicio;
	
	private TipoUsuarioServicio tipoUsuarioServicio;
	
	private RolServicio  rolServicio;
	
	private String passwordTemp;
	
	@Autowired
	public UsuarioControlador(UsuarioSession usuarioSession, ValidadorUsuario validadorUsuario,
			UsuarioServicio usuarioServicio, TipoDocumentoServicio tipoDocumentoServicio, GeneroServicio generoServicio,
			EscolaridadServicio escolaridadServicio, TipoUsuarioServicio tipoUsuarioServicio, RolServicio rolServicio) {
		this.usuarioSession = usuarioSession;
		this.validadorUsuario = validadorUsuario;
		this.usuarioServicio = usuarioServicio;
		this.tipoDocumentoServicio = tipoDocumentoServicio;
		this.generoServicio = generoServicio;
		this.escolaridadServicio = escolaridadServicio;
		this.tipoUsuarioServicio = tipoUsuarioServicio;
		this.rolServicio = rolServicio;
	}

	@ModelAttribute(value = "usuarioLogueado")
	public UsuarioSession getUsuarioSession() {
		return usuarioSession;
	}
	
	/**
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap modelMap) {
		modelMap.addAttribute("loggedinuser", obtenerNombreUsuario());
		return "accessDenied";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/panelUsuario")
	public String panelUsuario() {
		return "panelUsuario";
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public String crearNuevoUsuario(Model model) {
		model.addAttribute("nuevoUsuario", new UsuarioForma());
		iniciarListas(model, Utilidad.USUARIO_NUEVO, null);
		return "usuario";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public String procesarNuevoUsuario(@ModelAttribute("nuevoUsuario") UsuarioForma nuevoUsuario, Model model, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("msj_error", "Error guardando Usuario");
		}
		return validarUsuario(Utilidad.USUARIO_NUEVO_PROC, Utilidad.ESTADO_ACTIVO, nuevoUsuario, Utilidad.INDICE_DEFECTO, model, bindingResult, redirectAttributes);
	}
	
	/**
	 * 
	 * @param numeroPagina
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/paginaUsuario/{numeroPagina}")
	public String paginasUsuario(@PathVariable Integer numeroPagina, Model model) {
		List<Usuario> registroListaUsuario = this.usuarioServicio.buscarPorIdTipoUsuario(Utilidad.USUARIO_APLICACION, Utilidad.USUARIO_SISTEMA);
		PagedListHolder<Usuario> pagedListHolder = new PagedListHolder<>(registroListaUsuario);
		pagedListHolder.setPageSize(Utilidad.NUMERO_REGISTROS);
		pagedListHolder.setPage(numeroPagina - Utilidad.NUMERO_PAGINA_INICIO);
		int paginaActual = pagedListHolder.getPage() + Utilidad.NUMERO_PAGINA_INICIO;
		int paginaInicio = Math.max(Utilidad.NUMERO_PAGINA_INICIO, paginaActual - Utilidad.MAXIMO_PAGINA);
		int paginaFinal  = Math.min(paginaInicio + Utilidad.MINIMO_PAGINA, pagedListHolder.getPageCount());
		model.addAttribute("usuarios", pagedListHolder.getPageList());
		model.addAttribute("indiceInicio",paginaInicio);
		model.addAttribute("indiceFinal", paginaFinal);
		model.addAttribute("indiceActual",paginaActual);
		return "paginaUsuario";
	}
	
	/**
	 * 
	 * @param idUsuario
	 * @param indiceActual
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/editar/usuario", method = RequestMethod.GET)
	public String editarUsuario(@RequestParam("idUsuario") Integer idUsuario, @RequestParam("indiceActual") Integer indiceActual, Model model) {
		UsuarioForma usuarioForma = new UsuarioForma();
		usuarioForma.setUsuario(this.usuarioServicio.buscarPorId(idUsuario));
		this.passwordTemp = usuarioForma.getUsuario().getPassword();
		usuarioForma.getUsuario().setPassword(Utilidad.CADENA_DEFAULT);
		model.addAttribute("nuevoUsuario", usuarioForma);
		model.addAttribute("indiceActual", indiceActual);
		iniciarListas(model, Utilidad.USUARIO_EDITAR, usuarioForma);
		return "usuario";
	}
	
	/**
	 * 
	 * @param usuarioForma
	 * @param indiceActual
	 * @param model
	 * @param bindingResult
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/editar/usuario", method = RequestMethod.POST)
	public String procesarEditarUsuario(@ModelAttribute("nuevoUsuario") UsuarioForma usuarioForma, @ModelAttribute("indiceActual") int indiceActual, 
			Model model, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("msj_error", "Error guardando Usuario");
		}
		return validarUsuario(Utilidad.USUARIO_EDITAR_PROC, Utilidad.ESTADO_ACTIVO, usuarioForma, indiceActual, model, bindingResult, redirectAttributes);
	}
	
	/**
	 * 
	 * @param idUsuario
	 * @param idEstado
	 * @param indiceActual
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/activarDesactivar/usuario")
	public String activarDesactivar(@RequestParam("idUsuario") Integer idUsuario, @RequestParam("idEstado") Integer idEstado, @RequestParam("indiceActual") int indiceActual, RedirectAttributes redirectAttributes) {
		String msj = "Usuario activado con éxito";
		this.usuarioServicio.cambiarEstadoUsuario(idUsuario, idEstado);
		if (idEstado == Utilidad.ESTADO_INACTIVO) {
			msj = "Usuario desactivado con éxito";
		}
		redirectAttributes.addFlashAttribute("msj_ext", msj);
		return "redirect:/paginaUsuario/" + indiceActual;
	}
	
	/**
	 * 
	 * @param origen
	 * @param idEstado
	 * @param usuario
	 * @param indiceActual
	 * @param model
	 * @param bindingResult
	 * @param redirectAttributes
	 * @return
	 */
	private String validarUsuario(Integer origen, Integer idEstado, UsuarioForma usuarioForma, int indiceActual, Model model, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		this.validadorUsuario.validate(usuarioForma, bindingResult);
		if (!bindingResult.hasErrors()) {
			if (origen == Utilidad.USUARIO_EDITAR_PROC) {
				if (usuarioForma.getUsuario().getPassword().equals(Utilidad.CADENA_DEFAULT)) {
					usuarioForma.getUsuario().setPassword(this.passwordTemp);
				}else {
					usuarioForma.getUsuario().setPassword(QuickPasswordEncodingGenerator.passwordEncoder(usuarioForma.getUsuario().getPassword()));
				}
			}else {
				if (usuarioForma.isJavaScript()) {
					if (usuarioForma.getUsuario().getPassword().equals(Utilidad.CADENA_DEFAULT)) { /** Si el password no se modifico se asigna el password anterior*/
						usuarioForma.getUsuario().setPassword(usuarioForma.getPasswordTemp());
					}else {
						usuarioForma.getUsuario().setPassword(QuickPasswordEncodingGenerator.passwordEncoder(usuarioForma.getUsuario().getPassword()));
					}
				}else {
					usuarioForma.getUsuario().setPassword(QuickPasswordEncodingGenerator.passwordEncoder(usuarioForma.getUsuario().getPassword()));
				}
			}
			
			this.usuarioServicio.guardar(usuarioForma, idEstado);
			redirectAttributes.addFlashAttribute("msj_ext", "Usuario guardado con éxito");
			return obtenerJSP(origen, indiceActual, false, redirectAttributes);
		}else {
			iniciarListas(model, origen, usuarioForma);
			return obtenerJSP(origen, indiceActual, true, redirectAttributes);
		}
	}
	
	/**
	 * 
	 * @param origen
	 * @param indiceActual
	 * @param error
	 * @return
	 */
	private String obtenerJSP(Integer origen, int indiceActual, boolean error, RedirectAttributes redirectAttributes) {
		String ruta = null;
		switch (origen) {
		case Utilidad.USUARIO_NUEVO_PROC:
			if (!error) {
				if (indiceActual == Utilidad.INDICE_DEFECTO) {
					ruta = "redirect:/usuario";
				}else {
					ruta = "redirect:/paginaUsuario/" + indiceActual;
				}
			}else {
				ruta = "usuario";
			}
			break;
		case Utilidad.USUARIO_EDITAR_PROC:
			if (!error) {								
				ruta = "redirect:/paginaUsuario/" + indiceActual;
			}else{
				ruta = "usuario";
			}
			break;
		default:
			break;
		}
		return ruta;
	}
	
	/**
	 * 
	 * @return
	 */
	private String obtenerNombreUsuario() {
		String nombreUsuario = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			nombreUsuario = ((UserDetails)principal).getUsername();
		} else {
			nombreUsuario = principal.toString();
		}
		
		return nombreUsuario;
	}
	
	/**
	 * 
	 * @param model
	 * @param origen
	 * @param usuarioForma
	 */
	private void iniciarListas(Model model, int origen, UsuarioForma usuarioForma) {
		model.addAttribute("tiposDocumentoUsuario", this.tipoDocumentoServicio.buscarTiposDocumentoUsuario());
		model.addAttribute("generos", this.generoServicio.buscarTodos());
		model.addAttribute("escolaridadesUsuario", this.escolaridadServicio.buscarEscolaridadesUsuario());
		model.addAttribute("roles", this.rolServicio.buscarTodos());
		if (origen == Utilidad.USUARIO_EDITAR || origen == Utilidad.USUARIO_NUEVO_PROC) {
			model.addAttribute("rolesUsuario", usuarioForma.getUsuario().getRoles());
		}
		model.addAttribute("tiposUsuario", this.tipoUsuarioServicio.buscarTodos());
	}

}
