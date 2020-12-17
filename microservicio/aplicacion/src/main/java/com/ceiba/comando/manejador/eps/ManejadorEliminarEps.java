package com.ceiba.comando.manejador.eps;

import org.springframework.stereotype.Component;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.servicio.eps.ServicioEliminarEps;


@Component
public class ManejadorEliminarEps implements ManejadorComando<Long> {

    private final ServicioEliminarEps servicioEliminarEps;

    public ManejadorEliminarEps(ServicioEliminarEps servicioEliminarEps) {
        this.servicioEliminarEps = servicioEliminarEps;
    }

    public void ejecutar(Long idEps) {
        this.servicioEliminarEps.ejecutar(idEps);
    }
}
