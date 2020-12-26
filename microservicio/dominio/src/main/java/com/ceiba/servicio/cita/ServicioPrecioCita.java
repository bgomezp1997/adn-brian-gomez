package com.ceiba.servicio.cita;

import com.ceiba.cache.CacheUtil;
import com.ceiba.modelo.util.EnumParametro;
import com.ceiba.modelo.util.EnumTipoParametro;
import com.ceiba.servicio.util.EnumEstratos;

public class ServicioPrecioCita {
	
	private static final Integer CIEN_PORCIENTO = 100;
	
	public ServicioPrecioCita() {}

    public Double ejecutar(String estrato, String especialidad) {
    	Integer estratoNumerico = estrato != null ? Integer.parseInt(estrato) : null;
    	Double precioCita = obtenerPrecioCita(especialidad);
    	Double descuento = obtenerDescuento(estratoNumerico) / CIEN_PORCIENTO * precioCita;
        return precioCita - descuento;
    }
    
    
    private Double obtenerPrecioCita(String especialidad) {
		return Double.valueOf(CacheUtil.obtainParameterByTipoParametroAndParametro(EnumTipoParametro.ESPECIALIDAD, EnumParametro.valueOf(especialidad)));
	}
	
	private Double obtenerDescuento(Integer estrato) {
		if(estrato == null)
			return Double.valueOf(0);
		
		if(estrato < EnumEstratos.ESTRATO_TRES.getValue()) {
			return Double.valueOf(CacheUtil.obtainParameterByTipoParametroAndParametro(EnumTipoParametro.GENERAL, EnumParametro.DSCTO_ESTRATO_BAJO));
		} else if(estrato >= EnumEstratos.ESTRATO_TRES.getValue() && estrato < EnumEstratos.ESTRATO_CUATRO.getValue()) {
			return Double.valueOf(CacheUtil.obtainParameterByTipoParametroAndParametro(EnumTipoParametro.GENERAL, EnumParametro.DSCTO_ESTRATO_MEDIO));
		} else {
			return Double.valueOf(CacheUtil.obtainParameterByTipoParametroAndParametro(EnumTipoParametro.GENERAL, EnumParametro.DSCTO_ESTRATO_ALTO));
		}
	}

}
