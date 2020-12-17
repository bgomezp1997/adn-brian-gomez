package com.ceiba.comando.manejador.paciente;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.servicio.paciente.ServicioEliminarPaciente;

import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarPaciente implements ManejadorComando<Long> {

    private final ServicioEliminarPaciente servicioEliminarUsuario;

    public ManejadorEliminarPaciente(ServicioEliminarPaciente servicioEliminarUsuario) {
        this.servicioEliminarUsuario = servicioEliminarUsuario;
    }

    public void ejecutar(Long idPaciente) {
        this.servicioEliminarUsuario.ejecutar(idPaciente);
    }
}
