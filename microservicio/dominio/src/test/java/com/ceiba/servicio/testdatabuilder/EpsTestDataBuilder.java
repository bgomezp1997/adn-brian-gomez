package com.ceiba.servicio.testdatabuilder;

import com.ceiba.modelo.entidad.Eps;

public class EpsTestDataBuilder {

	private Long id;
	private String nombre;
	private String nit;
	private String telefono;
	private String email;

	public EpsTestDataBuilder() {
		nombre = "proteccion";
		nit = "5448554-5";
		telefono = "311354415";
		email = "prot@prot.mail";
	}

	public EpsTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public Eps build() {
		return new Eps(id, nombre, nit, telefono, email);
	}
}
