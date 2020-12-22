package com.ceiba.consulta.paciente;

import java.util.List;

import com.ceiba.modelo.dto.DtoPaciente;
import com.ceiba.puerto.dao.DaoPaciente;

import org.springframework.stereotype.Component;

@Component
public class ManejadorListarPacientes {

	private final DaoPaciente daoPaciente;

	public ManejadorListarPacientes(DaoPaciente daoPaciente) {
		this.daoPaciente = daoPaciente;
	}

	public List<DtoPaciente> ejecutar() {
		return this.daoPaciente.listar();
	}
}
