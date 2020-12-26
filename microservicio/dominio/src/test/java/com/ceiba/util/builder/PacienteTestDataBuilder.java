package com.ceiba.util.builder;

import java.time.LocalDateTime;

import com.ceiba.modelo.entidad.Paciente;

public class PacienteTestDataBuilder {

    private Long id;
    private String nombres;
    private String apellidos;
    private String identificacion;
    private String email;
    private String estrato;
    private LocalDateTime fechaCreacion;
    private Long idEps;

    public PacienteTestDataBuilder() {
    	nombres = "Brian";
    	apellidos = "Gomez";
    	identificacion = "123456";
    	email = "brian.gomez@ceiba.com.co";
    	estrato = "3";
        fechaCreacion = LocalDateTime.now();
        idEps = Long.valueOf(2);
    }

    public PacienteTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Paciente build() {
        return new Paciente(id, nombres, apellidos, fechaCreacion, identificacion, email, idEps, estrato);
    }
}
