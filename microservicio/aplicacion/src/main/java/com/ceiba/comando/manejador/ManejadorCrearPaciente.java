package com.ceiba.comando.manejador;

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

    public ManejadorCrearPaciente(FabricaPaciente fabricaUsuario, ServicioCrearPaciente servicioCrearUsuario) {
        this.fabricaPaciente = fabricaUsuario;
        this.servicioCrearPaciente = servicioCrearUsuario;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoPaciente comandoUsuario) {
        Paciente paciente = this.fabricaPaciente.crear(comandoUsuario);
        return new ComandoRespuesta<>(this.servicioCrearPaciente.ejecutar(paciente));
    }
}
