package com.ceiba.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.puerto.repositorio.RepositorioPaciente;
import com.ceiba.servicio.ServicioActualizarPaciente;
import com.ceiba.servicio.ServicioCrearPaciente;
import com.ceiba.servicio.ServicioEliminarPaciente;

@Configuration
public class BeanServicio {

	@Bean
	public ServicioCrearPaciente servicioCrearUsuario(RepositorioPaciente repositorioUsuario) {
		return new ServicioCrearPaciente(repositorioUsuario);
	}

	@Bean
	public ServicioEliminarPaciente servicioEliminarUsuario(RepositorioPaciente repositorioUsuario) {
		return new ServicioEliminarPaciente(repositorioUsuario);
	}

	@Bean
	public ServicioActualizarPaciente servicioActualizarUsuario(RepositorioPaciente repositorioUsuario) {
		return new ServicioActualizarPaciente(repositorioUsuario);
	}

}
