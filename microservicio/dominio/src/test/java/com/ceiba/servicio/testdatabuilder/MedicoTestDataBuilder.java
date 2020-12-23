package com.ceiba.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.modelo.entidad.Medico;

public class MedicoTestDataBuilder {

	private Long id;
	private String nombres;
	private String apellidos;
	private LocalDateTime fechaCreacion;
	private String identificacion;
	private String email;
	private String especialidad;
	private String numeroTarjetaProfesional;

	public MedicoTestDataBuilder() {
		nombres = "Brian";
		apellidos = "Gomez";
		fechaCreacion = LocalDateTime.now();
		identificacion = "54545454";
		email = "brian.gomez@mail.com";
		especialidad = "CORNEOLOGO";
		numeroTarjetaProfesional = "5488796847";
	}

	public MedicoTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public Medico build() {
		return new Medico(id, nombres, apellidos, fechaCreacion, identificacion, email, especialidad, numeroTarjetaProfesional);
	}
}
