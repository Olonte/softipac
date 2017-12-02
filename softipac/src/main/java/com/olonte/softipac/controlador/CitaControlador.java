package com.olonte.softipac.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.olonte.softipac.modelo.Agenda;
import com.olonte.softipac.modelo.UsuarioSession;
import com.olonte.softipac.servicio.CitaServicio;
import com.olonte.softipac.servicio.DiagnosticoServcio;
import com.olonte.softipac.servicio.EpsServicio;
import com.olonte.softipac.servicio.EscolaridadServicio;
import com.olonte.softipac.servicio.GeneroServicio;
import com.olonte.softipac.servicio.ParentescoServicio;
import com.olonte.softipac.servicio.TipoDocumentoServicio;
import com.olonte.softipac.servicio.UsuarioServicio;

@Controller
@Scope(value = "session")
public class CitaControlador {
	
	private UsuarioSession usuarioSession;
	
	private CitaServicio citaServicio;
	
	private UsuarioServicio usuarioServicio;
	
	private TipoDocumentoServicio tipoDocumentoServicio;
	
	private GeneroServicio generoServicio;
	
	private EscolaridadServicio escolaridadServicio;
	
	private EpsServicio epsServicio;
	
	private DiagnosticoServcio diagnosticoServicio;
	
	private ParentescoServicio parentescoServicio;
	
	@Autowired	
	public CitaControlador(UsuarioSession usuarioSession, CitaServicio citaServicio, UsuarioServicio usuarioServicio,
			TipoDocumentoServicio tipoDocumentoServicio, GeneroServicio generoServicio,
			EscolaridadServicio escolaridadServicio, EpsServicio epsServicio, DiagnosticoServcio diagnosticoServicio,
			ParentescoServicio parentescoServicio) {
		this.usuarioSession = usuarioSession;
		this.citaServicio = citaServicio;
		this.usuarioServicio = usuarioServicio;
		this.tipoDocumentoServicio = tipoDocumentoServicio;
		this.generoServicio = generoServicio;
		this.escolaridadServicio = escolaridadServicio;
		this.epsServicio = epsServicio;
		this.diagnosticoServicio = diagnosticoServicio;
		this.parentescoServicio = parentescoServicio;
	}
	
	@RequestMapping(value="/panelCita")
	public String panelCita(){
		return "panelCita";
	}

	@RequestMapping(value = "/agenda", method = RequestMethod.GET)
	public String crearNuevaAgenda(Model model) {
		model.addAttribute("nuevaAgenda", new Agenda());
		model.addAttribute("tiposDocumento", this.tipoDocumentoServicio.buscarTodos());
		model.addAttribute("generos", this.generoServicio.buscarTodos());
		model.addAttribute("escolaridades", this.escolaridadServicio.buscarTodos());
		model.addAttribute("eps", this.epsServicio.buscarTodos());
		model.addAttribute("diagnosticos", this.diagnosticoServicio.buscarTodos());
		model.addAttribute("parentescos", this.parentescoServicio.buscarTodos());
		return "agenda";
	}
	
	@RequestMapping(value = "/agenda", method = RequestMethod.POST)
	public String procesarNuevaAgenda(@ModelAttribute("nuevaAgenda") Agenda nuevaAgenda, BindingResult bindingResult, RedirectAttributes redirectAttributes){
		if (!bindingResult.hasErrors()) {
			this.citaServicio.guardar(nuevaAgenda);
			redirectAttributes.addFlashAttribute("msj_ext","Paciente guardado con éxito");
		}else {
			redirectAttributes.addFlashAttribute("msj_err","Error grabando el Paciente");
		}
		return "redirect:/agenda";
	}
	
	@ModelAttribute(value = "usuarioLogueado")
	public UsuarioSession getUsuarioSession() {
		return usuarioSession;
	}
	
	@RequestMapping(value = "/listadoAgenda")
	public String listarAgenda(Model model){
		model.addAttribute("citas", this.citaServicio.buscarTodos());
		return "listadoAgenda";
	}
	
	@RequestMapping(value = "/editar/agenda")
	public String editarCita(Model model, @RequestParam("idUsuario") Integer idUsuario) {
		Agenda agenda = new Agenda();
		agenda = this.citaServicio.buscarUsuarioAgenda(idUsuario);
		model.addAttribute("nuevaAgenda", agenda);
		model.addAttribute("horas",this.citaServicio.obtenerHoras(agenda));
		model.addAttribute("tiposDocumento", this.tipoDocumentoServicio.buscarTodos());
		model.addAttribute("generos", this.generoServicio.buscarTodos());
		model.addAttribute("escolaridades", this.escolaridadServicio.buscarTodos());
		model.addAttribute("eps", this.epsServicio.buscarTodos());
		model.addAttribute("diagnosticos", this.diagnosticoServicio.buscarTodos());
		model.addAttribute("diagnosticosPaciente", agenda.getPaciente().getDiagnosticos());
		model.addAttribute("parentescos", this.parentescoServicio.buscarTodos());
		return "agenda";
	}
	
}
