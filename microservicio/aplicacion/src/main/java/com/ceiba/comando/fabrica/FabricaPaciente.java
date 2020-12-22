package com.ceiba.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.comando.ComandoPaciente;
import com.ceiba.modelo.entidad.Paciente;

@Component
public class FabricaPaciente {

    public Paciente crear(ComandoPaciente comandoPaciente) {
        return new Paciente(
        		comandoPaciente.getId(), 
        		comandoPaciente.getNombres(), 
        		comandoPaciente.getApellidos(), 
        		comandoPaciente.getFechaCreacion(), 
        		comandoPaciente.getIdentificacion(), 
        		comandoPaciente.getEmail(), 
        		comandoPaciente.getEps().getId(), 
        		comandoPaciente.getEstrato()
        );
    }

}
