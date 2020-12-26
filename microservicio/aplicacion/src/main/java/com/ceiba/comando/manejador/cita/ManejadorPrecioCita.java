package com.ceiba.comando.manejador.cita;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comando.ComandoPrecio;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.servicio.cita.ServicioPrecioCita;

@Component
public class ManejadorPrecioCita implements ManejadorComandoRespuesta<ComandoPrecio, ComandoRespuesta<Double>> {

	private final ServicioPrecioCita servicioPrecioCita;

	public ManejadorPrecioCita(ServicioPrecioCita servicioPrecioCita) {
		this.servicioPrecioCita = servicioPrecioCita;
	}

	public ComandoRespuesta<Double> ejecutar(ComandoPrecio comandoPrecio) {
		return new ComandoRespuesta<>(this.servicioPrecioCita.ejecutar(comandoPrecio.getEstrato(), comandoPrecio.getEspecialidad()));
	}
	
	
}
