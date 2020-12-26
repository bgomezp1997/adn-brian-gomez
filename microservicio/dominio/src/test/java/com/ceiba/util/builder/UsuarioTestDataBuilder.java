package com.ceiba.util.builder;

import com.ceiba.modelo.entidad.Usuario;

public class UsuarioTestDataBuilder {

	private Long id;
	private String username;
	private String password;

	public UsuarioTestDataBuilder() {
		username = "brian";
		password = "1235";
	}

	public UsuarioTestDataBuilder conId(Long id) {
		this.id = id;	
		return this;
	}

	public Usuario build() {
		return new Usuario(id, password, username);
	}
}
