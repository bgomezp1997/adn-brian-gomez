package com.ceiba.comando.manejador.medico;

import org.springframework.stereotype.Component;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.servicio.medico.ServicioEliminarMedico;


@Component
public class ManejadorEliminarMedico implements ManejadorComando<Long> {

    private final ServicioEliminarMedico servicioEliminarMedico;

    public ManejadorEliminarMedico(ServicioEliminarMedico servicioEliminarMedico) {
        this.servicioEliminarMedico = servicioEliminarMedico;
    }

    public void ejecutar(Long idMedico) {
        this.servicioEliminarMedico.ejecutar(idMedico);
    }
}
