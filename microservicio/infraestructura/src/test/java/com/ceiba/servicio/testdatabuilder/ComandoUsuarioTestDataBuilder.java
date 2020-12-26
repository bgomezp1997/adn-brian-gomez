package com.ceiba.servicio.testdatabuilder;

import com.ceiba.comando.ComandoUsuario;

public class ComandoUsuarioTestDataBuilder {

	private Long id;
    private String username;
    private String password;

    public ComandoUsuarioTestDataBuilder() {
    	username = "brian";
    	password = "12345";
    }

    public ComandoUsuario build() {
        return new ComandoUsuario(id, password, username);
    }
}
