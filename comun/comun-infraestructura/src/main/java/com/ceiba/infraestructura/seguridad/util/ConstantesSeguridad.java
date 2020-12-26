package com.ceiba.infraestructura.seguridad.util;

public class ConstantesSeguridad {
	
	private ConstantesSeguridad() {}

	// Seguridad
	public static final String SECRET = "!#@dnC31b4";
	public static final long EXPIRATION_TIME = 100_000;
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	
	// Endpoints
	public static final String ENDPOINT_LOGIN = "/usuario/login";
	

}
