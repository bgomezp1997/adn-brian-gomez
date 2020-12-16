package com.ceiba.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.comando.ComandoPaciente;

public class ComandoPacienteTestDataBuilder {

	private Long id;
    private String nombres;
    private String apellidos;
    private String identificacion;
    private String email;
    private String estrato;
    private LocalDateTime fechaCreacion;
    private Long idEps;

    public ComandoPacienteTestDataBuilder() {
    	nombres = "Brian";
    	apellidos = "Gomez";
    	identificacion = "123456";
    	email = "brian.gomez@ceiba.com.co";
    	estrato = "3";
        fechaCreacion = LocalDateTime.now();
        idEps = Long.valueOf(1);
    }

    public ComandoPaciente build() {
        return new ComandoPaciente(id, nombres, apellidos, fechaCreacion, identificacion, email, idEps, estrato);
    }
}
