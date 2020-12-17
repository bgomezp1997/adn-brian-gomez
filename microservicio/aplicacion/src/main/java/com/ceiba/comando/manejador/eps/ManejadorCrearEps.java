package com.ceiba.comando.manejador.eps;

import org.springframework.stereotype.Component;
import com.ceiba.ComandoRespuesta;
import com.ceiba.comando.ComandoEps;
import com.ceiba.comando.fabrica.FabricaEps;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.modelo.entidad.Eps;
import com.ceiba.servicio.eps.ServicioCrearEps;

@Component
public class ManejadorCrearEps implements ManejadorComandoRespuesta<ComandoEps, ComandoRespuesta<Long>> {

    private final FabricaEps fabricaEps;
    private final ServicioCrearEps servicioCrearEps;

    public ManejadorCrearEps(FabricaEps fabricaEps, ServicioCrearEps servicioCrearEps) {
        this.fabricaEps = fabricaEps;
        this.servicioCrearEps = servicioCrearEps;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoEps comandoEps) {
        Eps eps = this.fabricaEps.crear(comandoEps);
        return new ComandoRespuesta<>(this.servicioCrearEps.ejecutar(eps));
    }
}
