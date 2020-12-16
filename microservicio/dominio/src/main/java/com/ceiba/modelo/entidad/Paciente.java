package com.ceiba.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarNumerico;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarRegex;

@Getter
public class Paciente {

	private static final String SE_DEBE_INGRESAR_LOS_NOMBRES = "Se debe ingresar los nombres";
	private static final String SE_DEBE_INGRESAR_LOS_APELLIDOS = "Se debe ingresar los apellidos";
	private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creaci\u00f3n";
	private static final String SE_DEBE_INGRESAR_LA_IDENTIFICACION_DEL_USUARIO = "Se debe ingresar la identificaci\u00f3n";
	private static final String SE_DEBE_INGRESAR_EL_EMAIL = "Se debe ingresar el email";
	private static final String EMAIL_INVALIDO = "El formato del email es inv\u00e1lido";
	private static final String SE_DEBE_SELECCIONAR_LA_EPS = "Se debe seleccionar la EPS";
	private static final String SE_DEBE_INGRESAR_EL_ESTRATO = "Se debe ingresar el estrato";
	private static final String EL_VALOR_INGRESADO_DEBE_SER_NUMERICO = "El valor ingresado debe ser num\u00e9rico";

	private static final String REGEX_EMAIL = "^(.+)@(.+)$";

	private Long id;
	private String nombres;
	private String apellidos;
	private LocalDateTime fechaCreacion;
	private String identificacion;
	private String email;
	private Long idEps;
	private String estrato;

	public Paciente(Long id, String nombres, String apellidos, LocalDateTime fechaCreacion, String identificacion,
			String email, Long idEps, String estrato) {

		validarObligatorio(nombres, SE_DEBE_INGRESAR_LOS_NOMBRES);
		validarObligatorio(apellidos, SE_DEBE_INGRESAR_LOS_APELLIDOS);
		validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);
		validarObligatorio(identificacion, SE_DEBE_INGRESAR_LA_IDENTIFICACION_DEL_USUARIO);
		validarObligatorio(email, SE_DEBE_INGRESAR_EL_EMAIL);
		validarRegex(email, REGEX_EMAIL, EMAIL_INVALIDO);
		validarObligatorio(idEps, SE_DEBE_SELECCIONAR_LA_EPS);
		validarObligatorio(estrato, SE_DEBE_INGRESAR_EL_ESTRATO);
		validarNumerico(estrato, EL_VALOR_INGRESADO_DEBE_SER_NUMERICO);
		

		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaCreacion = fechaCreacion;
		this.identificacion = identificacion;
		this.email = email;
		this.id = id;
		this.idEps = idEps;
		this.estrato = estrato;
	}

}
