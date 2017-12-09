package com.olonte.softipac.impl.servicio;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olonte.softipac.json.CitaJSON;
import com.olonte.softipac.json.JSON;
import com.olonte.softipac.modelo.Afinidad;
import com.olonte.softipac.modelo.AfinidadUsuarioId;
import com.olonte.softipac.modelo.Agenda;
import com.olonte.softipac.modelo.Cita;
import com.olonte.softipac.modelo.CitaUsuarioId;
import com.olonte.softipac.modelo.Estado;
import com.olonte.softipac.modelo.Hora;
import com.olonte.softipac.modelo.RegistroListaAgenda;
import com.olonte.softipac.modelo.UsuarioSession;
import com.olonte.softipac.predicado.CitaPredicado;
import com.olonte.softipac.repositorio.CitaRepositorio;
import com.olonte.softipac.servicio.AfinidadServicio;
import com.olonte.softipac.servicio.CitaServicio;
import com.olonte.softipac.servicio.EstadoServicio;
import com.olonte.softipac.servicio.ParentescoServicio;
import com.olonte.softipac.servicio.TipoCitaServicio;
import com.olonte.softipac.servicio.TipoUsuarioServicio;
import com.olonte.softipac.servicio.UsuarioServicio;

@Service
@Scope(value = "session")
public class CitaImplServicio implements CitaServicio {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private CitaRepositorio citaRepositorio;
	
	private TipoCitaServicio tipoCitaServicio;
	
	private TipoUsuarioServicio tipoUsuarioServicio;
	
	private ParentescoServicio parentescoServicio;
	
	private EstadoServicio estadoServicio;
	
	private UsuarioServicio usuarioServicio;
	
	private AfinidadServicio afinidadServicio;
	
	private UsuarioSession usuarioSession;
	
	@Autowired
	public CitaImplServicio(CitaRepositorio citaRepositorio, TipoCitaServicio tipoCitaServicio,
			TipoUsuarioServicio tipoUsuarioServicio, ParentescoServicio parentescoServicio,
			EstadoServicio estadoServicio, UsuarioServicio usuarioServicio, AfinidadServicio afinidadServicio,
			UsuarioSession usuarioSession) {
		this.citaRepositorio = citaRepositorio;
		this.tipoCitaServicio = tipoCitaServicio;
		this.tipoUsuarioServicio = tipoUsuarioServicio;
		this.parentescoServicio = parentescoServicio;
		this.estadoServicio = estadoServicio;
		this.usuarioServicio = usuarioServicio;
		this.afinidadServicio = afinidadServicio;
		this.usuarioSession = usuarioSession;
	}

	@Override
	@Transactional(readOnly = false)
	public void guardar(Agenda agenda) {
		Integer idTipoCita = 1;
		Integer idTipoUsuarioPaciente = 3;
		Integer idTipoUsuarioAcudiente = 5;
		Integer idEstado = 2;
		Integer idParentesco = 1;
		Estado estado = this.estadoServicio.bucarporId(idEstado);
		/**
		 * Se procesa el Paciente y el Acudiente
		 * 
		 */
		agenda.getPaciente().setTipoUsuario(this.tipoUsuarioServicio.buscarPorId(idTipoUsuarioPaciente));
		agenda.getAcudiente().setTipoUsuario(this.tipoUsuarioServicio.buscarPorId(idTipoUsuarioAcudiente));
		agenda.getPaciente().setEstado(estado);
		agenda.getAcudiente().setEstado(estado);
		agenda.getPaciente().setParentesco(this.parentescoServicio.bucarPorId(idParentesco));
		this.usuarioServicio.guardar(agenda.getPaciente());
		this.usuarioServicio.guardar(agenda.getAcudiente());
		 /*
		 * Se procesa la Afinidad
		 */
		 AfinidadUsuarioId afinidadUsuarioId = new AfinidadUsuarioId();
		 Afinidad afinidad = new Afinidad();
		 afinidadUsuarioId.setUsuario_idusuario(agenda.getPaciente());
		 afinidadUsuarioId.setIdfamiliar(agenda.getAcudiente());
		 afinidad.setAfinidadUsuarioId(afinidadUsuarioId);
		 this.afinidadServicio.guardar(afinidad);
		/**
		 * Se procesa la Cita
		 */
		CitaUsuarioId citaUsuarioId = new CitaUsuarioId();
		agenda.getCita().setTipoCita(this.tipoCitaServicio.buscarPorId(idTipoCita));
		agenda.getCita().setEstado(estado);
		citaUsuarioId.setUsuario_idusuapl(this.usuarioSession);
		citaUsuarioId.setUsuario_idusuario(agenda.getPaciente());
		agenda.getCita().setCitaUsuarioId(citaUsuarioId);
		this.citaRepositorio.save(agenda.getCita());
	}
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<RegistroListaAgenda> buscarTodos() {
		return CitaPredicado.buscarCitas(entityManager);
	}
	
	@Override
	@Transactional(readOnly = true)
	public CitaJSON buscarPorDocumento(String documento) {
		return JSON.obtenerCitaJSON(this.citaRepositorio.findOne(CitaPredicado.buscarPorDocumento(documento)));
	}

	@Override
	@Transactional(readOnly = true)
	public Agenda buscarUsuarioAgenda(Integer idUsuario) {
		Agenda agenda = new Agenda();
		agenda.setCita(buscarPorIdPaciente(idUsuario));
		agenda.setPaciente(this.usuarioServicio.buscarPacientePorId(idUsuario));
		agenda.setAcudiente(this.usuarioServicio.buscarAcudientePorId(idUsuario));
		return agenda;
	}

	@Override
	@Transactional(readOnly = true)
	public Cita buscarPorIdPaciente(Integer idUsuario) {
		return this.citaRepositorio.findOne(CitaPredicado.buscarPorIdPaciente(idUsuario));
	}

	@Override
	public ArrayList<Hora> obtenerHoras(Agenda agenda) {
		ArrayList<Hora> horas = new ArrayList<Hora>();
		horas.add(agenda.getCita().getHora());
		return horas;
	}

	@Override
	public ArrayList<String> obtenerMeses() {
		ArrayList<String> meses = new ArrayList<>();
		meses.add("1 Mes");
		meses.add("2 Meses");
		meses.add("3 Meses");
		meses.add("4 Meses");
		meses.add("5 Meses");
		meses.add("6 Meses");
		meses.add("7 Meses");
		meses.add("8 Meses");
		meses.add("9 Meses");
		meses.add("10 Meses");
		meses.add("11 Meses");
		return meses;
	}
	
}
