package com.ceiba.comando.manejador.cita;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cache.CacheUtil;
import com.ceiba.comando.ComandoPrecio;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.modelo.util.EnumParametro;
import com.ceiba.modelo.util.EnumTipoParametro;
import com.ceiba.servicio.cita.ServicioPrecioCita;

@Component
public class ManejadorPrecioCita implements ManejadorComandoRespuesta<ComandoPrecio, ComandoRespuesta<Double>> {

	private final ServicioPrecioCita servicioPrecioCita;

	public ManejadorPrecioCita(ServicioPrecioCita servicioPrecioCita) {
		this.servicioPrecioCita = servicioPrecioCita;
	}

	public ComandoRespuesta<Double> ejecutar(ComandoPrecio comandoPrecio) {
		Integer estrato = Integer.parseInt(comandoPrecio.getEstrato());
		return new ComandoRespuesta<>(this.servicioPrecioCita.ejecutar(obtenerDescuento(estrato)/100, obtenerPrecioCita(comandoPrecio.getEspecialidad())));
	}
	
	private Double obtenerPrecioCita(String especialidad) {
		return Double.valueOf(CacheUtil.obtainParameterByTipoParametroAndParametro(EnumTipoParametro.ESPECIALIDAD, EnumParametro.valueOf(especialidad)));
	}
	
	private Double obtenerDescuento(Integer estrato) {
		if(estrato == null)
			return Double.valueOf(0);
		
		if(estrato < 3) {
			return Double.valueOf(CacheUtil.obtainParameterByTipoParametroAndParametro(EnumTipoParametro.GENERAL, EnumParametro.DSCTO_ESTRATO_BAJO));
		} else if(estrato >= 3 && estrato < 5) {
			return Double.valueOf(CacheUtil.obtainParameterByTipoParametroAndParametro(EnumTipoParametro.GENERAL, EnumParametro.DSCTO_ESTRATO_MEDIO));
		} else {
			return Double.valueOf(CacheUtil.obtainParameterByTipoParametroAndParametro(EnumTipoParametro.GENERAL, EnumParametro.DSCTO_ESTRATO_ALTO));
		}
	}
}
