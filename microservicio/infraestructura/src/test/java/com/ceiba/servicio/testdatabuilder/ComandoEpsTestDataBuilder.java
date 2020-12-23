package com.ceiba.servicio.testdatabuilder;

import com.ceiba.comando.ComandoEps;

public class ComandoEpsTestDataBuilder {

	private Long id;
	private String nombre;
	private String nit;
	private String telefono;
	private String email;

    public ComandoEpsTestDataBuilder() {
    	nombre = "Protección";
    	nit = "548646-5";
    	telefono = "3111584454";
    	email = "proteccion@mail.com";
    }

    public ComandoEps build() {
        return new ComandoEps(id, nombre, nit, telefono, email);
    }
}
