package com.olonte.softipac.controlador;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
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
import com.olonte.softipac.modelo.Datos;
import com.olonte.softipac.modelo.Diagnostico;
import com.olonte.softipac.modelo.RegistroListaAgenda;
import com.olonte.softipac.modelo.RegistroListaCitaInformacion;
import com.olonte.softipac.modelo.UsuarioSession;
import com.olonte.softipac.servicio.CitaServicio;
import com.olonte.softipac.servicio.DatosServicio;
import com.olonte.softipac.servicio.DiagnosticoServcio;
import com.olonte.softipac.servicio.EpsServicio;
import com.olonte.softipac.servicio.EscolaridadServicio;
import com.olonte.softipac.servicio.GeneroServicio;
import com.olonte.softipac.servicio.HoraServicio;
import com.olonte.softipac.servicio.ParentescoServicio;
import com.olonte.softipac.servicio.TipoDocumentoServicio;
import com.olonte.softipac.servicio.UsuarioServicio;
import com.olonte.softipac.utilidad.Utilidad;
import com.olonte.softipac.validador.ValidadorUsuarioAgenda;

@Controller
@Scope(value = "session")
public class CitaControlador {
	
	private UsuarioSession usuarioSession;
	
	private ValidadorUsuarioAgenda validadorUsuarioAgenda;
	
	private CitaServicio citaServicio;
	
	private UsuarioServicio usuarioServicio;
	
	private HoraServicio horaServicio;
	
	private DatosServicio datosServicio;
	
	private TipoDocumentoServicio tipoDocumentoServicio;
	
	private GeneroServicio generoServicio;
	
	private EscolaridadServicio escolaridadServicio;
	
	private EpsServicio epsServicio;
	
	private DiagnosticoServcio diagnosticoServicio;
	
	private ParentescoServicio parentescoServicio;
	
	private Set<Diagnostico> diagnosticosTemp;
	
	@Autowired
	public CitaControlador(UsuarioSession usuarioSession, ValidadorUsuarioAgenda validadorUsuarioAgenda,
			CitaServicio citaServicio, UsuarioServicio usuarioServicio, HoraServicio horaServicio,
			DatosServicio datosServicio, TipoDocumentoServicio tipoDocumentoServicio, GeneroServicio generoServicio,
			EscolaridadServicio escolaridadServicio, EpsServicio epsServicio, DiagnosticoServcio diagnosticoServicio,
			ParentescoServicio parentescoServicio) {
		this.usuarioSession = usuarioSession;
		this.validadorUsuarioAgenda = validadorUsuarioAgenda;
		this.citaServicio = citaServicio;
		this.usuarioServicio = usuarioServicio;
		this.horaServicio = horaServicio;
		this.datosServicio = datosServicio;
		this.tipoDocumentoServicio = tipoDocumentoServicio;
		this.generoServicio = generoServicio;
		this.escolaridadServicio = escolaridadServicio;
		this.epsServicio = epsServicio;
		this.diagnosticoServicio = diagnosticoServicio;
		this.parentescoServicio = parentescoServicio;
	}

	@ModelAttribute(value = "usuarioLogueado")
	public UsuarioSession getUsuarioSession() {
		return this.usuarioSession;
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
		int transaccion = Utilidad.TRANS_GUARDAR;
		if (bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("msj_err","Error guardando la cita");
		}
		if (nuevaAgenda.getPaciente().getDiagnosticos().isEmpty()) {
			if (!nuevaAgenda.isJavaScript()) {
				if (this.diagnosticosTemp != null) {
					if (!this.diagnosticosTemp.isEmpty()) {
						nuevaAgenda.getPaciente().setDiagnosticos(this.diagnosticosTemp);
					}
				}
			}else{
				transaccion = Utilidad.TRANS_ACTUALIZAR;
			}
		}else{
			this.diagnosticosTemp = nuevaAgenda.getPaciente().getDiagnosticos();
			if (nuevaAgenda.isJavaScript()) {
				transaccion = Utilidad.TRANS_ACTUALIZAR;
			}
		}
		return validarAgenda(Utilidad.AGENDA_PROCESADA, Utilidad.CITA_AGENDA, transaccion, Utilidad.ESTADO_INACTIVO, nuevaAgenda, Utilidad.INDICE_DEFECTO, model, bindingResult, redirectAttributes);
	}
	
	/**
	 * 
	 * @param numeroPagina
	 * @param model
	 * @return
	*/
	@RequestMapping(value ="/paginaAgenda/{numeroPagina}")
	public String paginasAgenda(@PathVariable Integer numeroPagina, Model model) {
		List<RegistroListaAgenda> registroListaAgenda = this.citaServicio.buscarCitasAgenda();
		PagedListHolder<RegistroListaAgenda> pagedListHolder = new PagedListHolder<>(registroListaAgenda);
		pagedListHolder.setPageSize(Utilidad.NUMERO_REGISTROS);
		pagedListHolder.setPage(numeroPagina - Utilidad.NUMERO_PAGINA_INICIO);
		int paginaActual = pagedListHolder.getPage() + Utilidad.NUMERO_PAGINA_INICIO;
		int paginaInicio = Math.max(Utilidad.NUMERO_PAGINA_INICIO, paginaActual - Utilidad.MAXIMO_PAGINA);
		int paginaFinal  = Math.min(paginaInicio + Utilidad.MINIMO_PAGINA, pagedListHolder.getPageCount());
		model.addAttribute("citasAgenda", pagedListHolder.getPageList());
		model.addAttribute("indiceInicio",paginaInicio);
		model.addAttribute("indiceFinal", paginaFinal);
		model.addAttribute("indiceActual",paginaActual);
		return "paginaAgenda";
	}
	
	/**
	 * 
	 * @param model
	 * @param idUsuario
	 * @return
	 */
	@RequestMapping(value = "/editar/agenda", method = RequestMethod.GET)
	public String editarAgenda(@RequestParam("idUsuario") Integer idUsuario, @RequestParam("indiceActual") Integer indiceActual, Model model) {
		Agenda agenda = new Agenda();
		agenda = this.citaServicio.buscarUsuarioAgenda(idUsuario,Utilidad.USUARIO_ACUDIENTE,Utilidad.CITA_AGENDA);			
		this.diagnosticosTemp = agenda.getPaciente().getDiagnosticos();
		model.addAttribute("nuevaAgenda", agenda);		
		model.addAttribute("indiceActual", indiceActual);
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
	public String procesarEdicionCita(@ModelAttribute("nuevaAgenda") Agenda nuevaAgenda, BindingResult bindingResult, @ModelAttribute("indiceActual") int indiceActual, Model model, RedirectAttributes redirectAttributes) {
		
		if (bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("msj_error", "Error guardando la cita");
		}
		
		if (nuevaAgenda.getPaciente().getDiagnosticos().isEmpty()) {
			nuevaAgenda.getPaciente().setDiagnosticos(this.diagnosticosTemp);
		}
		return validarAgenda(Utilidad.AGENDA_EDIT_PROC, Utilidad.CITA_AGENDA, Utilidad.TRANS_ACTUALIZAR, Utilidad.ESTADO_INACTIVO, nuevaAgenda, indiceActual, model, bindingResult, redirectAttributes);
	}
	
	/**
	 * 
	 * @param idUsuario
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/cancelar/agenda")
	public String cancelarCita(@RequestParam("idUsuario") Integer idUsuario, @RequestParam("idTipoCita") Integer idTipoCita, @RequestParam("indiceActual") Integer indiceActual, RedirectAttributes redirectAttributes) {	
		this.citaServicio.cambiarEstadoCita(idUsuario,idTipoCita,Utilidad.ESTADO_CANCELADO);
		redirectAttributes.addFlashAttribute("msj_ext","Cita cancelada con éxito");
		
		if (idTipoCita == Utilidad.CITA_AGENDA) {
			return "redirect:/paginaAgenda/" + indiceActual;
		}else{
			return "redirect:/paginaCitaInformacion/" + indiceActual;
		}
		
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
	 * @param idUsuario
	 * @param indiceActual
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/citaInformacion", method = RequestMethod.GET)
	public String crearNuevaCitaInformacion(@RequestParam("idUsuario") Integer idUsuario, @RequestParam("indiceActual") int indiceActual, Model model) {
		CitaInformacion citaInformacion = new CitaInformacion();
		Agenda agenda = new Agenda();
		agenda = this.citaServicio.buscarUsuarioAgenda(idUsuario,Utilidad.USUARIO_ACUDIENTE,Utilidad.CITA_AGENDA);								
		citaInformacion.setCita(agenda.getCita());
		citaInformacion.getCita().setFechaCitaIni(agenda.getCita().getFechaCitaIni());
		citaInformacion.setPaciente(agenda.getPaciente());
			
		if (agenda.getAcudiente().getParentesco_idparentesco().getIdParentesco() == Utilidad.MADRE) {
			citaInformacion.setMadre(agenda.getAcudiente());
		}else if (agenda.getAcudiente().getParentesco_idparentesco().getIdParentesco() == Utilidad.PADRE) {
			citaInformacion.setPadre(agenda.getAcudiente());
		}
				
		citaInformacion.setAcudiente(agenda.getAcudiente());		
			
		this.diagnosticosTemp = citaInformacion.getPaciente().getDiagnosticos();
		
		model.addAttribute("nuevaCitaInformacion", citaInformacion);
		model.addAttribute("indiceActual",indiceActual);
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
    public String procesarNuevaCitaInformacion(@ModelAttribute("nuevaCitaInformacion") CitaInformacion citaInformacion, BindingResult bindingResult, @ModelAttribute("indiceActual") int indiceActual,
    		Model model, RedirectAttributes redirectAttributes){

		if (citaInformacion.getPaciente().getDiagnosticos().isEmpty()) {
			citaInformacion.getPaciente().setDiagnosticos(diagnosticosTemp);
		}
		return validarAgenda(Utilidad.CITA_INFO_PROC, Utilidad.CITA_INFORMACION, Utilidad.TRANS_GUARDAR,  Utilidad.ESTADO_PENDIENTE, citaInformacion, indiceActual, model, bindingResult, redirectAttributes);
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/crear/citaInformacion", method = RequestMethod.GET)
	public String crearCitaInformacion(Model model) {
		CitaInformacion citaInformacion = new CitaInformacion();
		citaInformacion.setUsuarioAplica(getUsuarioSession().obtenerNombresApellidos());
		model.addAttribute("nuevaCitaInformacion", citaInformacion);
		iniciarListas(model, citaInformacion, Utilidad.CITA_INFO_CREAR);
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
	@RequestMapping(value = "/crear/citaInformacion", method = RequestMethod.POST)
	public String procesarCrearCitaInformacion(@ModelAttribute("nuevaCitaInformacion") CitaInformacion citaInformacion, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
		int transaccion = Utilidad.TRANS_GUARDAR;
		if (bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("msj_err","Error guardando la cita");
		}
		if (citaInformacion.isJavaScript()) {
			transaccion = Utilidad.TRANS_ACTUALIZAR;
		}
		return validarAgenda(Utilidad.CITA_INFO_PROC, Utilidad.CITA_INFORMACION, transaccion,  Utilidad.ESTADO_PENDIENTE, citaInformacion, Utilidad.INDICE_DEFECTO, model, bindingResult, redirectAttributes);
	}
	
	/**
	 * 
	 * @param numeroPagina
	 * @param model
	 * @return
	 */
	@RequestMapping(value ="/paginaCitaInformacion/{numeroPagina}")
	public String paginasCitaInformacion(@PathVariable Integer numeroPagina, Model model){
		List<RegistroListaCitaInformacion> registroListaCitaInformacion = this.citaServicio.buscarCitasInformacion();
		PagedListHolder<RegistroListaCitaInformacion> pagedListHolder = new PagedListHolder<>(registroListaCitaInformacion);
		pagedListHolder.setPageSize(Utilidad.NUMERO_REGISTROS);
		pagedListHolder.setPage(numeroPagina - Utilidad.NUMERO_PAGINA_INICIO);
		int paginaActual = pagedListHolder.getPage() + Utilidad.NUMERO_PAGINA_INICIO;
		int paginaInicio = Math.max(Utilidad.NUMERO_PAGINA_INICIO, paginaActual - Utilidad.MAXIMO_PAGINA);
		int paginaFinal  = Math.min(paginaInicio + Utilidad.MINIMO_PAGINA, pagedListHolder.getPageCount());
		model.addAttribute("citasInformacion", pagedListHolder.getPageList());
		model.addAttribute("indiceInicio",paginaInicio);
		model.addAttribute("indiceFinal", paginaFinal);
		model.addAttribute("indiceActual",paginaActual);
		return "paginaCitaInformacion";
	}
	
	/**
	 * 
	 * @param idUsuario
	 * @param indiceActual
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/editar/citaInformacion", method = RequestMethod.GET)
	public String editarCitaInformacion(@RequestParam("idUsuario") Integer idUsuario, @RequestParam("indiceActual") Integer indiceActual, Model model) {
		CitaInformacion citaInformacion = new CitaInformacion();
		
		Agenda agenda = new Agenda();
		agenda = this.citaServicio.buscarUsuarioAgenda(idUsuario, Utilidad.USUARIO_PACIENTE, Utilidad.CITA_INFORMACION);		
		
		citaInformacion.setCita(agenda.getCita());		
		citaInformacion.setPaciente(agenda.getPaciente());
		citaInformacion.setAcudiente(agenda.getAcudiente());
		
		if (agenda.getAcudiente().getParentesco_idparentesco().getIdParentesco() == Utilidad.MADRE) {
			citaInformacion.setMadre(agenda.getAcudiente());
			citaInformacion.setPadre(this.usuarioServicio.buscarFamiliarPorId(citaInformacion.getPaciente(), Utilidad.PADRE));
		}else if (agenda.getAcudiente().getParentesco_idparentesco().getIdParentesco() == Utilidad.PADRE) {
			citaInformacion.setPadre(agenda.getAcudiente());
			citaInformacion.setMadre(this.usuarioServicio.buscarFamiliarPorId(citaInformacion.getPaciente(), Utilidad.MADRE));
		}else {
			citaInformacion.setMadre(this.usuarioServicio.buscarFamiliarPorId(citaInformacion.getPaciente(), Utilidad.MADRE));
			citaInformacion.setPadre(this.usuarioServicio.buscarFamiliarPorId(citaInformacion.getPaciente(), Utilidad.PADRE));
		}		
		
		citaInformacion.setUsuarioAplica(citaInformacion.getCita().getCitaId().getUsuario_idusuapl().getNombres() + " " +
				citaInformacion.getCita().getCitaId().getUsuario_idusuapl().getPrimerApellido());
	
		model.addAttribute("nuevaCitaInformacion", citaInformacion);
		model.addAttribute("indiceActual",indiceActual);
		
		iniciarListas(model, citaInformacion, Utilidad.CITA_INFO_EDIT);
		
		return "citaInformacion";
	}
	/**
	 * 
	 * @param citaInformacion
	 * @param bindingResult
	 * @param indiceActual
	 * @param model
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/editar/citaInformacion", method = RequestMethod.POST)
	public String procesarEditarCitaInformacion(@ModelAttribute("nuevaCitaInformacion") CitaInformacion citaInformacion,  BindingResult bindingResult, @ModelAttribute("indiceActual") int indiceActual,
    		Model model, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("msj_error", "Error guardando la cita");
		}
		
		return validarAgenda(Utilidad.CITA_INFO_EDIT, Utilidad.CITA_INFORMACION, Utilidad.TRANS_ACTUALIZAR,  Utilidad.ESTADO_PENDIENTE, citaInformacion, indiceActual, model, bindingResult, redirectAttributes);
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
		List<Datos> datos = this.datosServicio.buscarTodos();	
		switch (origen) {
			case Utilidad.AGENDA_PROCESADA:
				model.addAttribute("horas", this.horaServicio.buscarAgendaPorFecha(agenda.getCita().getFechaCitaIni(),Utilidad.CITA_AGENDA,Utilidad.HORA_AGENDA));
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
				model.addAttribute("horas",this.citaServicio.obtenerHoras(agenda,Utilidad.HORA_AGENDA));
				break;
			case Utilidad.CITA_INFO_CREAR:
				((CitaInformacion)agenda).setUsuarioAplica(getUsuarioSession().obtenerNombresApellidos());
				break;
			default:
				break;
		}
		
		model.addAttribute("tiposDocumento", this.tipoDocumentoServicio.buscarTodos(datos));
		model.addAttribute("tiposDocumentoUsuario", this.tipoDocumentoServicio.buscarTiposDocumentoUsuario(datos));
		model.addAttribute("generos", this.generoServicio.buscarTodos(datos));
		model.addAttribute("escolaridades", this.escolaridadServicio.buscarTodos(datos));
		model.addAttribute("escolaridadesUsuario", this.escolaridadServicio.buscarEscolaridadesUsuario(datos));
		model.addAttribute("eps", this.epsServicio.buscarTodos(datos));
		model.addAttribute("diagnosticos", this.diagnosticoServicio.buscarTodos(datos));
		model.addAttribute("parentescos", this.parentescoServicio.buscarTodos(datos));	
		
		if (origen != Utilidad.AGENDA_NUEVA && origen != Utilidad.AGENDA_PROCESADA && origen != Utilidad.CITA_INFO_CREAR) {
			model.addAttribute("diagnosticosPaciente", agenda.getPaciente().getDiagnosticos());
		}

	}
	
	/**
	 * 
	 * @param agenda
	 * @param model
	 * @param bindingResult
	 * @param redirectAttributes
	 * @return
	 */
	private String validarAgenda(int origen, int tipoCita, int transaccion, Integer idEstado, Agenda agenda,
			int indiceActual, Model model, BindingResult bindingResult, 
			RedirectAttributes redirectAttributes) {		
		this.validadorUsuarioAgenda.validate(agenda, bindingResult);		
		if (!bindingResult.hasErrors()) {
			this.citaServicio.guardarActualizar(tipoCita, transaccion, idEstado, agenda);
			redirectAttributes.addFlashAttribute("msj_ext","Cita guardada con éxito");
			return obtenerJSP(origen, tipoCita, indiceActual, agenda, false);
		}else {
			iniciarListas(model, agenda, origen);
			return obtenerJSP(origen, tipoCita, indiceActual, agenda, true);
		}
	}
	
	/**
	 * 
	 * @param tipoCita
	 * @param error
	 * @return
	 */
	private String obtenerJSP(int origen, int tipoCita,int indiceActual, Agenda agenda, boolean error) {
		String ruta = null;
		
		switch (tipoCita) {
		case Utilidad.CITA_AGENDA:
			if (!error) {
				if (indiceActual == Utilidad.INDICE_DEFECTO) {
					ruta = "redirect:/agenda";
				}else {
					ruta = "redirect:/paginaAgenda/" + indiceActual;
				}
				
			}else{
				ruta = "agenda";
			}
			break;
		case Utilidad.CITA_INFORMACION:
			if (!error) {
				if (indiceActual == Utilidad.INDICE_DEFECTO) {
					ruta = "redirect:/crear/citaInformacion";
				}else{
					if (origen == Utilidad.CITA_INFO_PROC ) {
						ruta = "redirect:/paginaAgenda/" + indiceActual;
					}else {
						ruta = "redirect:/paginaCitaInformacion/" + indiceActual;
					}
				}
			}else {
				ruta = "citaInformacion";
			}
		default:
			break;
		}
		return ruta;
	}
	
}
