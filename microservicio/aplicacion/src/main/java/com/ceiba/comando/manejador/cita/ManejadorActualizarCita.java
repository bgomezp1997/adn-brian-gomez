package com.ceiba.comando.manejador.cita;

import org.springframework.stereotype.Component;

import com.ceiba.cache.ObjCacheManager;
import com.ceiba.comando.ComandoCita;
import com.ceiba.comando.fabrica.FabricaCita;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.modelo.entidad.Cita;
import com.ceiba.modelo.util.EnumParametro;
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
        ObjCacheManager objCacheManager = new ObjCacheManager();
    	Integer cantidadCitasPorDia = Integer.parseInt((String) objCacheManager.retrieveFromCache(EnumParametro.CANTIDAD_CITAS_DIA.getIndicative()));
        this.servicioActualizarCita.ejecutar(cita, cantidadCitasPorDia);
    }
}
