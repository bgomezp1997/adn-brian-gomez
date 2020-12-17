package com.ceiba.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.comando.ComandoEps;
import com.ceiba.modelo.entidad.Eps;

@Component
public class FabricaEps {
	
	public Eps crear(ComandoEps comandoEps) {
		return new Eps(
				comandoEps.getId(), 
				comandoEps.getNombre(), 
				comandoEps.getNit(), 
				comandoEps.getTelefono(), 
				comandoEps.getEmail()
		);
	}

}
