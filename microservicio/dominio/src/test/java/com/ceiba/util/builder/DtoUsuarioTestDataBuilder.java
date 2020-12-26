package com.ceiba.util.builder;

import com.ceiba.modelo.dto.DtoUsuario;

public class DtoUsuarioTestDataBuilder {

	private Long id;
	private String username;
	private String password;

	public DtoUsuarioTestDataBuilder() {
		id = 1L;
		username = "brian";
		password = "1235";
	}

	public DtoUsuario build() {
		return new DtoUsuario(id, password, username);
	}
}
