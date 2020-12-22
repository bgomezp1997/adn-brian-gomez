package com.ceiba.consulta.medico;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.dto.DtoMedico;
import com.ceiba.puerto.dao.DaoMedico;

@Component
public class ManejadorListarMedicos {

	private final DaoMedico daoMedico;

	public ManejadorListarMedicos(DaoMedico daoMedico) {
		this.daoMedico = daoMedico;
	}

	public List<DtoMedico> ejecutar() {
		return this.daoMedico.listar();
	}
}
