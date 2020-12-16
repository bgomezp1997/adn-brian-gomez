package com.ceiba.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarNumerico;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarRegex;

import lombok.Getter;

@Getter
public class Eps {
	
	private static final String SE_DEBE_INGRESAR_EL_NOMBRE = "Se debe ingresar el nombre";
	private static final String SE_DEBE_INGRESAR_EL_NIT = "Se debe ingresar el nit";
	private static final String SE_DEBE_INGRESAR_EL_TELEFONO = "Se debe ingresar el tel\u00e9fono";
	private static final String EL_VALOR_INGRESADO_DEBE_SER_NUMERICO = "El valor ingresado debe ser num\u00e9rico";
	private static final String SE_DEBE_INGRESAR_EL_EMAIL = "Se debe ingresar el email";
	private static final String EMAIL_INVALIDO = "El formato del email es inv\u00e1lido";
	
	private static final String REGEX_EMAIL = "^(.+)@(.+)$";
	
	private Long id;
	private String nombre;
	private String nit;
	private String telefono;
	private String email;
	
	public Eps(Long id, String nombre, String nit, String telefono, String email) {
		validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE);
		validarObligatorio(nit, SE_DEBE_INGRESAR_EL_NIT);
		validarObligatorio(telefono, SE_DEBE_INGRESAR_EL_TELEFONO);
		validarNumerico(telefono, EL_VALOR_INGRESADO_DEBE_SER_NUMERICO);
		validarObligatorio(email, SE_DEBE_INGRESAR_EL_EMAIL);
		validarRegex(email, REGEX_EMAIL, EMAIL_INVALIDO);
		
		this.id = id;
		this.nombre = nombre;
		this.nit = nit;
		this.telefono = telefono;
		this.email = email;
	}

}
