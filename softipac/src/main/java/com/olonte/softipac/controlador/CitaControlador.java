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
import com.olonte.softipac.modelo.CitaInformacion;
import com.olonte.softipac.modelo.Usuario;
import com.olonte.softipac.modelo.UsuarioSession;
import com.olonte.softipac.servicio.CitaServicio;
import com.olonte.softipac.servicio.DiagnosticoServcio;
import com.olonte.softipac.servicio.EpsServicio;
import com.olonte.softipac.servicio.EscolaridadServicio;
import com.olonte.softipac.servicio.GeneroServicio;
import com.olonte.softipac.servicio.ParentescoServicio;
import com.olonte.softipac.servicio.TipoDocumentoServicio;
import com.olonte.softipac.servicio.UsuarioServicio;
import com.olonte.softipac.utilidad.Utilidad;
import com.olonte.softipac.validador.ValidadorUsuario;

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
	public String panelCita() {
		
		return "panelCita";
		
	}
	
	
	@RequestMapping(value = "/agenda", method = RequestMethod.GET)
	public String crearNuevaAgenda(Model model) {
		
		model.addAttribute("nuevaAgenda", new Agenda());
		iniciarListas(model);
		
		return "agenda";
		
	}
	
	@RequestMapping(value = "/agenda", method = RequestMethod.POST)
	public String procesarNuevaAgenda(@ModelAttribute("nuevaAgenda") Agenda nuevaAgenda, Model model, BindingResult bindingResult, RedirectAttributes redirectAttributes){
		
		ValidadorUsuario validadorUsuario = new ValidadorUsuario();
		validadorUsuario.validate(nuevaAgenda, bindingResult);
		
		if (bindingResult.hasErrors()) {
			iniciarListas(model);
			model.addAttribute("diagnosticosPaciente", nuevaAgenda.getPaciente().getDiagnosticos());
			return "agenda";
		}else{
			this.citaServicio.guardar(nuevaAgenda);
			redirectAttributes.addFlashAttribute("msj_ext","Paciente guardado con éxito");
		}
	
		return "redirect:/agenda";
		
	}
	
	@ModelAttribute(value = "usuarioLogueado")
	public UsuarioSession getUsuarioSession() {
		
		return usuarioSession;
		
	}
	
	@RequestMapping(value = "/listadoAgenda")
	public String listarAgenda(Model model) {
		
		model.addAttribute("citas", this.citaServicio.buscarTodos());
		
		return "listadoAgenda";
		
	}
	
	@RequestMapping(value = "/editar/agenda", method = RequestMethod.GET)
	public String editarCita(Model model, @RequestParam("idUsuario") Integer idUsuario) {
		
		Agenda agenda = new Agenda();
		agenda = this.citaServicio.buscarUsuarioAgenda(idUsuario);
		
		model.addAttribute("nuevaAgenda", agenda);
		model.addAttribute("horas",this.citaServicio.obtenerHoras(agenda));
		model.addAttribute("diagnosticosPaciente", agenda.getPaciente().getDiagnosticos());
		iniciarListas(model);
		
		return "agenda";
		
	}
	
	@RequestMapping(value = "/editar/agenda", method = RequestMethod.POST)
	public String procesarEdicionCita(@ModelAttribute("nuevaAgenda") Agenda nuevaAgenda, Model model, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		ValidadorUsuario validadorUsuario = new ValidadorUsuario();
		validadorUsuario.validate(nuevaAgenda, bindingResult);
		
		if (bindingResult.hasErrors()) {
			iniciarListas(model);
			model.addAttribute("diagnosticosPaciente", nuevaAgenda.getPaciente().getDiagnosticos());
			return "agenda";
		}else{
			this.citaServicio.guardar(nuevaAgenda);
			redirectAttributes.addFlashAttribute("msj_ext","Paciente guardado con éxito");
		}
	
		return "redirect:/agenda";
		
	}
	
	@RequestMapping(value = "/citaInformacion", method = RequestMethod.GET)
	public String crearNuevaCitaInformacion(Model model, @RequestParam("idUsuario") Integer idUsuario) {
		
		CitaInformacion citaInformacion = new CitaInformacion();
		Usuario familiar = this.usuarioServicio.buscarAcudientePorId(idUsuario);
		
		citaInformacion.setCita(this.citaServicio.buscarPorIdPaciente(idUsuario));
		citaInformacion.setPaciente(this.usuarioServicio.buscarPacientePorId(idUsuario));
		
		if (familiar.getParentesco().getIdParentesco() == Utilidad.MADRE) {
			citaInformacion.setMadre(familiar);
		}else if (familiar.getParentesco().getIdParentesco() == Utilidad.PADRE) {
			citaInformacion.setPadre(familiar);
		}
		
		citaInformacion.setAcudiente(familiar);
		citaInformacion.setUsuarioAplica(getUsuarioSession().obtenerNombresApellidos());
		
		model.addAttribute("citaInformacion", citaInformacion);
		model.addAttribute("diagnosticosPaciente", citaInformacion.getPaciente().getDiagnosticos());
		iniciarListas(model);
		
		return "citaInformacion";
		
	}
	
	@RequestMapping(value = "/citaInformacion", method = RequestMethod.POST)
	public String procesarNuevaCitaInformacion(@ModelAttribute("citaInformacion") CitaInformacion citaInformacion, Model model, BindingResult bindingResult, RedirectAttributes redirectAttributes){
		
		return "redirect:/citaInformacion";
		
	}
	
	
	
	private void iniciarListas(Model model) {
		
		model.addAttribute("tiposDocumento", this.tipoDocumentoServicio.buscarTodos());
		model.addAttribute("generos", this.generoServicio.buscarTodos());
		model.addAttribute("escolaridades", this.escolaridadServicio.buscarTodos());
		model.addAttribute("eps", this.epsServicio.buscarTodos());
		model.addAttribute("diagnosticos", this.diagnosticoServicio.buscarTodos());
		model.addAttribute("parentescos", this.parentescoServicio.buscarTodos());
		
	}
}
