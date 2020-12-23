package com.ceiba.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.comando.ComandoMedico;

public class ComandoMedicoTestDataBuilder {

	private Long id;
    private String nombres;
    private String apellidos;
    private String identificacion;
    private String email;
    private String especialista;
    private LocalDateTime fechaCreacion;
    private String numeroTarjetaProfesional;

    public ComandoMedicoTestDataBuilder() {
    	nombres = "Brian";
    	apellidos = "Gomez";
    	identificacion = "123456";
    	email = "brian.gomez@ceiba.com.co";
    	especialista = "RETINOLOGO";
        fechaCreacion = LocalDateTime.now();
        numeroTarjetaProfesional = "54875151";
    }

    public ComandoMedico build() {
        return new ComandoMedico(id, nombres, apellidos, fechaCreacion, identificacion, email, especialista, numeroTarjetaProfesional);
    }
}
