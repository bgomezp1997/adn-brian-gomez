package com.ceiba.dominio.excepcion;

public class ExcepcionDiaNoLaborable extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionDiaNoLaborable(String mensaje) {
        super(mensaje);
    }
}
