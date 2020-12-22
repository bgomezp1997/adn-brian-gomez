package com.ceiba.comando.manejador.cita;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cache.CacheUtil;
import com.ceiba.comando.ComandoCita;
import com.ceiba.comando.fabrica.FabricaCita;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.modelo.dto.DtoParametro;
import com.ceiba.modelo.entidad.Cita;
import com.ceiba.modelo.util.EnumParametro;
import com.ceiba.modelo.util.EnumTipoParametro;
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
		Integer cantidadCitasPorDia = Integer.parseInt(CacheUtil.obtainParameterByTipoParametroAndParametro(EnumTipoParametro.GENERAL, EnumParametro.CANTIDAD_CITAS_DIA));
		List<DtoParametro> fechasFestivasParams = CacheUtil.obtainListByTipoParametro(EnumTipoParametro.FESTIVO);
		return new ComandoRespuesta<>(this.servicioCrearCita.ejecutar(cita, cantidadCitasPorDia, fechasFestivasParams));
	}
	
	
}
