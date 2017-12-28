package com.olonte.softipac.controlador;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.olonte.softipac.modelo.Agenda;
import com.olonte.softipac.modelo.CitaInformacion;
import com.olonte.softipac.modelo.Diagnostico;
import com.olonte.softipac.modelo.Usuario;
import com.olonte.softipac.modelo.UsuarioSession;
import com.olonte.softipac.servicio.CitaServicio;
import com.olonte.softipac.servicio.DiagnosticoServcio;
import com.olonte.softipac.servicio.EpsServicio;
import com.olonte.softipac.servicio.EscolaridadServicio;
import com.olonte.softipac.servicio.GeneroServicio;
import com.olonte.softipac.servicio.HoraServicio;
import com.olonte.softipac.servicio.ParentescoServicio;
import com.olonte.softipac.servicio.TipoDocumentoServicio;
import com.olonte.softipac.servicio.UsuarioServicio;
import com.olonte.softipac.utilidad.Utilidad;
import com.olonte.softipac.validador.ValidadorUsuario;

@Controller
@Scope(value = "session")
public class CitaControlador {
	
	private UsuarioSession usuarioSession;
	
	private ValidadorUsuario validadorUsuario;
	
	private CitaServicio citaServicio;
	
	private UsuarioServicio usuarioServicio;
	
	private HoraServicio horaServicio;
	
	private TipoDocumentoServicio tipoDocumentoServicio;
	
	private GeneroServicio generoServicio;
	
	private EscolaridadServicio escolaridadServicio;
	
	private EpsServicio epsServicio;
	
	private DiagnosticoServcio diagnosticoServicio;
	
	private ParentescoServicio parentescoServicio;
	
	private Set<Diagnostico> diagnosticosTemp;
	
	@Autowired
	public CitaControlador(UsuarioSession usuarioSession, ValidadorUsuario validadorUsuario, CitaServicio citaServicio,
			UsuarioServicio usuarioServicio, HoraServicio horaServicio, TipoDocumentoServicio tipoDocumentoServicio,
			GeneroServicio generoServicio, EscolaridadServicio escolaridadServicio, EpsServicio epsServicio,
			DiagnosticoServcio diagnosticoServicio, ParentescoServicio parentescoServicio) {
		this.usuarioSession = usuarioSession;
		this.validadorUsuario = validadorUsuario;
		this.citaServicio = citaServicio;
		this.usuarioServicio = usuarioServicio;
		this.horaServicio = horaServicio;
		this.tipoDocumentoServicio = tipoDocumentoServicio;
		this.generoServicio = generoServicio;
		this.escolaridadServicio = escolaridadServicio;
		this.epsServicio = epsServicio;
		this.diagnosticoServicio = diagnosticoServicio;
		this.parentescoServicio = parentescoServicio;
	}

	@ModelAttribute(value = "usuarioLogueado")
	public UsuarioSession getUsuarioSession() {
		return usuarioSession;
	}

	/**
	 * *****************************************************************************************************************************************
	 * 
	 * 										    	 		PANEL
	 * 
	 * ******************************************************************************************************************************************
	 */
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/panelCita")
	public String panelCita() {
		return "panelCita";
	}

	/**
	 * *****************************************************************************************************************************************
	 * 
	 * 										    	 		AGENDA
	 * 
	 * ******************************************************************************************************************************************
	 */
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/agenda", method = RequestMethod.GET)
	public String crearNuevaAgenda(Model model) {
		model.addAttribute("nuevaAgenda", new Agenda());
		iniciarListas(model, null, Utilidad.AGENDA_NUEVA);
		
		return "agenda";
	}
	
	/**
	 * 
	 * @param nuevaAgenda
	 * @param model
	 * @param bindingResult
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/agenda", method = RequestMethod.POST)
	public String procesarNuevaAgenda(@ModelAttribute("nuevaAgenda") Agenda nuevaAgenda, Model model, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (nuevaAgenda.getPaciente().getDiagnosticos().isEmpty()) {
			if (this.diagnosticosTemp != null) {
				if (!this.diagnosticosTemp.isEmpty()) {
					nuevaAgenda.getPaciente().setDiagnosticos(this.diagnosticosTemp);
				}
			}
		}else{
			this.diagnosticosTemp = nuevaAgenda.getPaciente().getDiagnosticos();
		}
		
		return validarAgenda(nuevaAgenda, model, bindingResult, redirectAttributes, Utilidad.AGENDA_PROCESADA);
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/listadoAgenda")
	public String listarAgenda(Model model) {
		model.addAttribute("citas", this.citaServicio.buscarTodos());
		return "listadoAgenda";
	}
	
	/**
	 * 
	 * @param model
	 * @param idUsuario
	 * @return
	 */
	@RequestMapping(value = "/editar/agenda", method = RequestMethod.GET)
	public String editarCita(Model model, @RequestParam("idUsuario") Integer idUsuario) {
		Agenda agenda = new Agenda();
		agenda = this.citaServicio.buscarUsuarioAgenda(idUsuario);
		
		this.diagnosticosTemp = agenda.getPaciente().getDiagnosticos();
		
		model.addAttribute("nuevaAgenda", agenda);
		
		iniciarListas(model, agenda, Utilidad.AGENDA_EDITADA);

		return "agenda";
	}
	
	/**
	 * 
	 * @param nuevaAgenda
	 * @param model
	 * @param bindingResult
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/editar/agenda", method = RequestMethod.POST)
	public String procesarEdicionCita(@ModelAttribute("nuevaAgenda") Agenda nuevaAgenda, Model model, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (nuevaAgenda.getPaciente().getDiagnosticos().isEmpty()) {
			nuevaAgenda.getPaciente().setDiagnosticos(this.diagnosticosTemp);
		}
		
		return validarAgenda(nuevaAgenda, model, bindingResult, redirectAttributes, Utilidad.AGENDA_EDIT_PROC);
	}
	

	@RequestMapping(value = "/cancelar/agenda")
	public String cancelarCita(@RequestParam("idUsuario") Integer idUsuario) {
		System.out.println("El idUsuario es " + idUsuario);
		return "redirect:/listadoAgenda";
	}
	
	/**
	 * *****************************************************************************************************************************************
	 * 
	 * 										    	 		CITA INFORMACION
	 * 
	 * ******************************************************************************************************************************************
	 */
	
	/**
	 * 
	 * @param model
	 * @param idUsuario
	 * @return
	 */
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
		iniciarListas(model, citaInformacion, Utilidad.CITA_INFO_NUEVA);
		
		return "citaInformacion";
	}
	
	/**
	 * 
	 * @param citaInformacion
	 * @param model
	 * @param bindingResult
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/citaInformacion", method = RequestMethod.POST)
	public String procesarNuevaCitaInformacion(@ModelAttribute("citaInformacion") CitaInformacion citaInformacion, Model model, BindingResult bindingResult, RedirectAttributes redirectAttributes){
		return "redirect:/citaInformacion";
	}
	
	/**
	 * *****************************************************************************************************************************************
	 * 
	 * 										    	 		METODOS PRIVADOS
	 * 
	 * ******************************************************************************************************************************************
	 */
	
	/**
	 * 
	 * @param model
	 * @param agenda
	 * @param origen
	 */
	private void iniciarListas(Model model, Agenda agenda, int origen) {
		switch (origen) {
			case Utilidad.AGENDA_PROCESADA:
				model.addAttribute("horas", this.horaServicio.buscarAgendaPorFecha(agenda.getCita().getFechaCitaIni()));
				if (agenda.getPaciente().getDiagnosticos().isEmpty()) {
					if (this.diagnosticosTemp != null) {
						if (!this.diagnosticosTemp.isEmpty()) {
							model.addAttribute("diagnosticosPaciente", this.diagnosticosTemp);
						}
					}
				}else{
					model.addAttribute("diagnosticosPaciente", agenda.getPaciente().getDiagnosticos());
				}
				break;
			case Utilidad.AGENDA_EDITADA:
				model.addAttribute("horas",this.citaServicio.obtenerHoras(agenda));
				break;
			default:
				break;
		}
		
		model.addAttribute("tiposDocumento", this.tipoDocumentoServicio.buscarTodos());
		model.addAttribute("generos", this.generoServicio.buscarTodos());
		model.addAttribute("escolaridades", this.escolaridadServicio.buscarTodos());
		model.addAttribute("eps", this.epsServicio.buscarTodos());
		model.addAttribute("diagnosticos", this.diagnosticoServicio.buscarTodos());
		
		if (origen != Utilidad.AGENDA_NUEVA && origen != Utilidad.AGENDA_PROCESADA) {
			model.addAttribute("diagnosticosPaciente", agenda.getPaciente().getDiagnosticos());
		}
		
		model.addAttribute("parentescos", this.parentescoServicio.buscarTodos());	
	}
	
	/**
	 * 
	 * @param agenda
	 * @param model
	 * @param bindingResult
	 * @param redirectAttributes
	 * @return
	 */
	private String validarAgenda(Agenda agenda, Model model, BindingResult bindingResult, RedirectAttributes redirectAttributes, int origen) {
		this.validadorUsuario.validate(agenda, bindingResult);
		
		if (bindingResult.hasErrors()) {
			iniciarListas(model, agenda, origen);
			return "agenda";
		}else{
			if (origen == Utilidad.AGENDA_EDIT_PROC) {
				this.citaServicio.actualizar(agenda);
			}else {
				this.citaServicio.guardar(agenda);
			}
			
			redirectAttributes.addFlashAttribute("msj_ext","Paciente guardado con éxito");
		}
	
		return "redirect:/agenda";
	}
	
}
