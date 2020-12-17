package com.ceiba.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.servicio.paciente.ServicioEliminarPaciente;

import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarPaciente implements ManejadorComando<Long> {

    private final ServicioEliminarPaciente servicioEliminarUsuario;

    public ManejadorEliminarPaciente(ServicioEliminarPaciente servicioEliminarUsuario) {
        this.servicioEliminarUsuario = servicioEliminarUsuario;
    }

    public void ejecutar(Long idUsuario) {
        this.servicioEliminarUsuario.ejecutar(idUsuario);
    }
}
