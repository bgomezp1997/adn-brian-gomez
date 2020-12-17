package com.ceiba.comando.manejador.eps;

import org.springframework.stereotype.Component;
import com.ceiba.comando.ComandoEps;
import com.ceiba.comando.fabrica.FabricaEps;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.modelo.entidad.Eps;
import com.ceiba.servicio.eps.ServicioActualizarEps;

@Component
public class ManejadorActualizarEps implements ManejadorComando<ComandoEps> {

    private final FabricaEps fabricaEps;
    private final ServicioActualizarEps servicioActualizarEps;

    public ManejadorActualizarEps(FabricaEps fabricaEps, ServicioActualizarEps servicioActualizarEps) {
        this.fabricaEps = fabricaEps;
        this.servicioActualizarEps = servicioActualizarEps;
    }

    public void ejecutar(ComandoEps comandoEps) {
        Eps eps = this.fabricaEps.crear(comandoEps);
        this.servicioActualizarEps.ejecutar(eps);
    }
}
