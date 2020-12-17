package com.ceiba.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.comando.ComandoMedico;
import com.ceiba.modelo.entidad.Medico;

@Component
public class FabricaMedico {
	
	public Medico crear(ComandoMedico comandoMedico) {
		return new Medico(
				comandoMedico.getId(), 
				comandoMedico.getNombres(), 
				comandoMedico.getApellidos(), 
				comandoMedico.getFechaCreacion(), 
				comandoMedico.getIdentificacion(),
				comandoMedico.getEmail(), 
				comandoMedico.getEspecialidad(), 
				comandoMedico.getNumeroTarjetaProfesional()
		);
	}

}
