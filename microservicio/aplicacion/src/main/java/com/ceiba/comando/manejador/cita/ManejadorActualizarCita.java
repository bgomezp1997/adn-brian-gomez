package com.ceiba.comando.manejador.cita;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.cache.CacheUtil;
import com.ceiba.comando.ComandoCita;
import com.ceiba.comando.fabrica.FabricaCita;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.modelo.dto.DtoParametro;
import com.ceiba.modelo.entidad.Cita;
import com.ceiba.modelo.util.EnumParametro;
import com.ceiba.modelo.util.EnumTipoParametro;
import com.ceiba.servicio.cita.ServicioActualizarCita;

@Component
public class ManejadorActualizarCita implements ManejadorComando<ComandoCita> {

    private final FabricaCita fabricaCita;
    private final ServicioActualizarCita servicioActualizarCita;

    public ManejadorActualizarCita(FabricaCita fabricaCita, ServicioActualizarCita servicioActualizarCita) {
        this.fabricaCita = fabricaCita;
        this.servicioActualizarCita = servicioActualizarCita;
    }

    public void ejecutar(ComandoCita comandoCita) {
        Cita cita = this.fabricaCita.crear(comandoCita);
        Integer cantidadCitasPorDia = Integer.parseInt(CacheUtil.obtainParameterByTipoParametroAndParametro(EnumTipoParametro.GENERAL, EnumParametro.CANTIDAD_CITAS_DIA));
		List<DtoParametro> fechasFestivasParams = CacheUtil.obtainListByTipoParametro(EnumTipoParametro.FESTIVO);
        this.servicioActualizarCita.ejecutar(cita, cantidadCitasPorDia, fechasFestivasParams);
    }
}
