package com.ceiba.servicio.cita;

import com.ceiba.cache.CacheUtil;
import com.ceiba.modelo.util.EnumParametro;
import com.ceiba.modelo.util.EnumTipoParametro;

public class ServicioPrecioCita {
	
	public ServicioPrecioCita() {}

    public Double ejecutar(String estrato, String especialidad) {
    	Integer estratoNumerico = estrato != null ? Integer.parseInt(estrato) : null;
    	Double precioCita = obtenerPrecioCita(especialidad);
    	Double descuento = obtenerDescuento(estratoNumerico)/100 * precioCita;
        return precioCita - descuento;
    }
    
    
    private Double obtenerPrecioCita(String especialidad) {
		return Double.valueOf(CacheUtil.obtainParameterByTipoParametroAndParametro(EnumTipoParametro.ESPECIALIDAD, EnumParametro.valueOf(especialidad)));
	}
	
	private Double obtenerDescuento(Integer estrato) {
		if(estrato == null)
			return Double.valueOf(0);
		
		if(estrato < 3) {
			return Double.valueOf(CacheUtil.obtainParameterByTipoParametroAndParametro(EnumTipoParametro.GENERAL, EnumParametro.DSCTO_ESTRATO_BAJO));
		} else if(estrato >= 3 && estrato < 4) {
			return Double.valueOf(CacheUtil.obtainParameterByTipoParametroAndParametro(EnumTipoParametro.GENERAL, EnumParametro.DSCTO_ESTRATO_MEDIO));
		} else {
			return Double.valueOf(CacheUtil.obtainParameterByTipoParametroAndParametro(EnumTipoParametro.GENERAL, EnumParametro.DSCTO_ESTRATO_ALTO));
		}
	}

}
