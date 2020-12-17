package com.ceiba.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.dto.DtoCita;
import com.ceiba.puerto.dao.DaoCita;

@Component
public class ManejadorListarCita {

	private final DaoCita daoCita;

	public ManejadorListarCita(DaoCita daoCita) {
		this.daoCita = daoCita;
	}

	public List<DtoCita> ejecutar() {
		return this.daoCita.listar();
	}
}
