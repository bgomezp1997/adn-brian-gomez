package com.ceiba.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import lombok.Getter;

@Getter
public class Usuario {
	
	private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_LA_CITA = "Se debe ingresar el username";
	private static final String SE_DEBE_SELECCIONAR_EL_USUARIO = "Se debe ingresar la contrase\u00f1a";
	
	private Long id;
	private String password;
	private String username;
	
	public Usuario(Long id, String password, String username) {
		validarObligatorio(password, SE_DEBE_INGRESAR_LA_FECHA_DE_LA_CITA);
		validarObligatorio(username, SE_DEBE_SELECCIONAR_EL_USUARIO);
		
		this.id = id;
		this.password = password;
		this.username = username;
	}

}
