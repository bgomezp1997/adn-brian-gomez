package com.ceiba.dominio.excepcion;

public class ExcepcionCitasExcedidas extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionCitasExcedidas(String mensaje) {
        super(mensaje);
    }
}
