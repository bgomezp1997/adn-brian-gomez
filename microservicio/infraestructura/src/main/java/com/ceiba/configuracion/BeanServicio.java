package com.ceiba.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.puerto.dao.DaoUsuario;
import com.ceiba.puerto.repositorio.RepositorioCita;
import com.ceiba.puerto.repositorio.RepositorioEps;
import com.ceiba.puerto.repositorio.RepositorioMedico;
import com.ceiba.puerto.repositorio.RepositorioPaciente;
import com.ceiba.puerto.repositorio.RepositorioUsuario;
import com.ceiba.servicio.cita.ServicioActualizarCita;
import com.ceiba.servicio.cita.ServicioCrearCita;
import com.ceiba.servicio.cita.ServicioEliminarCita;
import com.ceiba.servicio.cita.ServicioPrecioCita;
import com.ceiba.servicio.eps.ServicioActualizarEps;
import com.ceiba.servicio.eps.ServicioCrearEps;
import com.ceiba.servicio.eps.ServicioEliminarEps;
import com.ceiba.servicio.medico.ServicioActualizarMedico;
import com.ceiba.servicio.medico.ServicioCrearMedico;
import com.ceiba.servicio.medico.ServicioEliminarMedico;
import com.ceiba.servicio.paciente.ServicioActualizarPaciente;
import com.ceiba.servicio.paciente.ServicioCrearPaciente;
import com.ceiba.servicio.paciente.ServicioEliminarPaciente;
import com.ceiba.servicio.usuario.ServicioActualizarUsuario;
import com.ceiba.servicio.usuario.ServicioCrearUsuario;
import com.ceiba.servicio.usuario.ServicioEliminarUsuario;
import com.ceiba.servicio.usuario.ServicioUserDetail;

@Configuration
public class BeanServicio {

	/**
	 * Servicios de paciente
	 */
	@Bean
	public ServicioCrearPaciente servicioCrearPaciente(RepositorioPaciente repositorioUsuario) {
		return new ServicioCrearPaciente(repositorioUsuario);
	}

	@Bean
	public ServicioEliminarPaciente servicioEliminarPaciente(RepositorioPaciente repositorioUsuario) {
		return new ServicioEliminarPaciente(repositorioUsuario);
	}

	@Bean
	public ServicioActualizarPaciente servicioActualizarPaciente(RepositorioPaciente repositorioUsuario) {
		return new ServicioActualizarPaciente(repositorioUsuario);
	}
	
	/**
	 * Servicios de medico
	 */
	@Bean
	public ServicioCrearMedico servicioCrearMedico(RepositorioMedico repositorioMedico) {
		return new ServicioCrearMedico(repositorioMedico);
	}

	@Bean
	public ServicioEliminarMedico servicioEliminarMedico(RepositorioMedico repositorioMedico) {
		return new ServicioEliminarMedico(repositorioMedico);
	}

	@Bean
	public ServicioActualizarMedico servicioActualizarMedico(RepositorioMedico repositorioMedico) {
		return new ServicioActualizarMedico(repositorioMedico);
	}
	
	/**
	 * Servicios de eps
	 */
	@Bean
	public ServicioCrearEps servicioCrearEps(RepositorioEps repositorioEps) {
		return new ServicioCrearEps(repositorioEps);
	}

	@Bean
	public ServicioEliminarEps servicioEliminarEps(RepositorioEps repositorioEps) {
		return new ServicioEliminarEps(repositorioEps);
	}

	@Bean
	public ServicioActualizarEps servicioActualizarEps(RepositorioEps repositorioEps) {
		return new ServicioActualizarEps(repositorioEps);
	}
	
	/**
	 * Servicios de cita
	 */
	@Bean
	public ServicioCrearCita servicioCrearCita(RepositorioCita repositorioCita) {
		return new ServicioCrearCita(repositorioCita);
	}

	@Bean
	public ServicioEliminarCita servicioEliminarCita(RepositorioCita repositorioCita) {
		return new ServicioEliminarCita(repositorioCita);
	}

	@Bean
	public ServicioActualizarCita servicioActualizarCita(RepositorioCita repositorioCita) {
		return new ServicioActualizarCita(repositorioCita);
	}
	
	@Bean
	public ServicioPrecioCita servicioPrecioCita() {
		return new ServicioPrecioCita();
	}
	
	/**
	 * Servicios de eps
	 */
	@Bean
	public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
		return new ServicioCrearUsuario(repositorioUsuario);
	}

	@Bean
	public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
		return new ServicioEliminarUsuario(repositorioUsuario);
	}

	@Bean
	public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
		return new ServicioActualizarUsuario(repositorioUsuario);
	}
	
	@Bean
	public ServicioUserDetail servicioUserDetail(DaoUsuario daoUsuario) {
		return new ServicioUserDetail(daoUsuario);
	}

}
