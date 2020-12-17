package com.ceiba.comando.manejador.paciente;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comando.ComandoPaciente;
import com.ceiba.comando.fabrica.FabricaPaciente;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.modelo.entidad.Paciente;
import com.ceiba.servicio.paciente.ServicioCrearPaciente;

import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPaciente implements ManejadorComandoRespuesta<ComandoPaciente, ComandoRespuesta<Long>> {

    private final FabricaPaciente fabricaPaciente;
    private final ServicioCrearPaciente servicioCrearPaciente;

    public ManejadorCrearPaciente(FabricaPaciente fabricaPaciente, ServicioCrearPaciente servicioCrearPaciente) {
        this.fabricaPaciente = fabricaPaciente;
        this.servicioCrearPaciente = servicioCrearPaciente;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoPaciente comandoPaciente) {
        Paciente paciente = this.fabricaPaciente.crear(comandoPaciente);
        return new ComandoRespuesta<>(this.servicioCrearPaciente.ejecutar(paciente));
    }
}
