package com.ceiba.consulta.cita;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.dto.DtoCita;
import com.ceiba.puerto.dao.DaoCita;

@Component
public class ManejadorObtenerCita {
	
	private final DaoCita daoCita;

	public ManejadorObtenerCita(DaoCita daoCita) {
		this.daoCita = daoCita;
	}
	
	public DtoCita ejecutar(Long id) {
		return this.daoCita.obtener(id);
	}

}
