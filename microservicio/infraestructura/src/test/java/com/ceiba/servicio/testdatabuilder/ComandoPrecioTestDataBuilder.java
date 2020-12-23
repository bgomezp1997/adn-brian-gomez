package com.ceiba.servicio.testdatabuilder;

import com.ceiba.comando.ComandoPrecio;

public class ComandoPrecioTestDataBuilder {

	private String estrato;
	private String especialidad;

    public ComandoPrecioTestDataBuilder() {
    	especialidad = "RETINOLOGO";
    }
    
    public ComandoPrecioTestDataBuilder conEstratoAlto() {
    	estrato = "5";
    	return this;
    }
    
    public ComandoPrecioTestDataBuilder conEstratoMedio() {
    	estrato = "3";
    	return this;
    }
    
    public ComandoPrecioTestDataBuilder conEstratoBajo() {
    	estrato = "1";
    	return this;
    }

    public ComandoPrecio build() {
        return new ComandoPrecio(estrato, especialidad);
    }
}
