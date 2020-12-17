package com.ceiba.comando.manejador.paciente;

import com.ceiba.comando.ComandoPaciente;
import com.ceiba.comando.fabrica.FabricaPaciente;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.modelo.entidad.Paciente;
import com.ceiba.servicio.paciente.ServicioActualizarPaciente;

import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarPaciente implements ManejadorComando<ComandoPaciente> {

    private final FabricaPaciente fabricaPaciente;
    private final ServicioActualizarPaciente servicioActualizarPaciente;

    public ManejadorActualizarPaciente(FabricaPaciente fabricaPaciente, ServicioActualizarPaciente servicioActualizarPaciente) {
        this.fabricaPaciente = fabricaPaciente;
        this.servicioActualizarPaciente = servicioActualizarPaciente;
    }

    public void ejecutar(ComandoPaciente comandoPaciente) {
        Paciente paciente = this.fabricaPaciente.crear(comandoPaciente);
        this.servicioActualizarPaciente.ejecutar(paciente);
    }
}
