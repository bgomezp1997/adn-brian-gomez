package com.ceiba.consulta.paciente;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.dto.DtoPaciente;
import com.ceiba.puerto.dao.DaoPaciente;

@Component
public class ManejadorObtenerPaciente {
	
	private final DaoPaciente daoPaciente;

	public ManejadorObtenerPaciente(DaoPaciente daoPaciente) {
		this.daoPaciente = daoPaciente;
	}
	
	public DtoPaciente ejecutar(Long id) {
		return this.daoPaciente.obtener(id);
	}

}
