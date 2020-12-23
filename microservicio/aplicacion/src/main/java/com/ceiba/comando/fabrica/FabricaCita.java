package com.ceiba.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.comando.ComandoCita;
import com.ceiba.modelo.entidad.Cita;

@Component
public class FabricaCita {
	
	public Cita crear(ComandoCita comandoCita) {
		return new Cita(
				comandoCita.getId(), 
				comandoCita.getFechaCita(), 
				comandoCita.getPaciente().getId(), 
				comandoCita.getMedico().getId(),
				comandoCita.getPrecio()
		);
	}

}
