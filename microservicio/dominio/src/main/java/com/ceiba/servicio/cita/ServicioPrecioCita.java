package com.ceiba.servicio.cita;

public class ServicioPrecioCita {
	
	public ServicioPrecioCita() {}

    public Double ejecutar(Double porcentajeDescuento, Double precioCita) {
    	Double descuento = porcentajeDescuento * precioCita;
        return precioCita - descuento;
    }

}
