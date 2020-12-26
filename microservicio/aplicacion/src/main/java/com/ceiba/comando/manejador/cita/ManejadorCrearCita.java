package com.ceiba.comando.manejador.cita;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comando.ComandoCita;
import com.ceiba.comando.fabrica.FabricaCita;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.modelo.entidad.Cita;
import com.ceiba.servicio.cita.ServicioCrearCita;

@Component
public class ManejadorCrearCita implements ManejadorComandoRespuesta<ComandoCita, ComandoRespuesta<Long>> {

	private final FabricaCita fabricaCita;
	private final ServicioCrearCita servicioCrearCita;

	public ManejadorCrearCita(FabricaCita fabricaCita, ServicioCrearCita servicioCrearCita) {
		this.fabricaCita = fabricaCita;
		this.servicioCrearCita = servicioCrearCita;
	}

	public ComandoRespuesta<Long> ejecutar(ComandoCita comandoCita) {
		Cita cita = this.fabricaCita.crear(comandoCita);
		return new ComandoRespuesta<>(this.servicioCrearCita.ejecutar(cita));
	}
	
	
}
