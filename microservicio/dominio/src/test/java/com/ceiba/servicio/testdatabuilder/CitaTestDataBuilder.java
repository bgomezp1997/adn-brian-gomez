package com.ceiba.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.modelo.entidad.Cita;

public class CitaTestDataBuilder {

	private Long id;
	private LocalDateTime fechaCita;
	private Long idPaciente;
	private Long idMedico;
	private Double precio;

	public CitaTestDataBuilder() {
		fechaCita = LocalDateTime.now();
		idPaciente = 1L;
		idMedico = 1L;
		precio = 2D;
	}

	public CitaTestDataBuilder conId(Long id) {
		this.id = id;	
		return this;
	}
	
	public CitaTestDataBuilder siendoDomingo() {
		fechaCita = LocalDateTime.of(2020, 12, 27, 0, 0);
		return this;
	}

	public Cita build() {
		return new Cita(id, fechaCita, idPaciente, idMedico, precio);
	}
}
