package com.ceiba.consulta.medico;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.dto.DtoMedico;
import com.ceiba.puerto.dao.DaoMedico;

@Component
public class ManejadorObtenerMedico {
	
	private final DaoMedico daoMedico;

	public ManejadorObtenerMedico(DaoMedico daoMedico) {
		this.daoMedico = daoMedico;
	}
	
	public DtoMedico ejecutar(Long id) {
		return this.daoMedico.obtener(id);
	}

}
