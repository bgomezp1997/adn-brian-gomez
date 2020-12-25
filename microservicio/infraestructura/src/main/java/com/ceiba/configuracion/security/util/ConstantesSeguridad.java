package com.ceiba.configuracion.security.util;

public class ConstantesSeguridad {
	
	private ConstantesSeguridad() {}

	// Seguridad
	public static final String SECRET = "!#@dnC31b4";
	public static final long EXPIRATION_TIME = 900_000;
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	
	// Mensajes
	public static final String MENSAJE_ERROR_AUTENTICACION = "Hubo un error en la autenticacion del usuario";
	
	// Endpoints
	public static final String ENDPOINT_LOGIN = "/usuario/login";
	

}
