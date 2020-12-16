package com.ceiba.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comando.ComandoPaciente;
import com.ceiba.comando.fabrica.FabricaPaciente;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.modelo.entidad.Paciente;
import com.ceiba.servicio.ServicioCrearPaciente;

import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPaciente implements ManejadorComandoRespuesta<ComandoPaciente, ComandoRespuesta<Long>> {

    private final FabricaPaciente fabricaUsuario;
    private final ServicioCrearPaciente servicioCrearUsuario;

    public ManejadorCrearPaciente(FabricaPaciente fabricaUsuario, ServicioCrearPaciente servicioCrearUsuario) {
        this.fabricaUsuario = fabricaUsuario;
        this.servicioCrearUsuario = servicioCrearUsuario;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoPaciente comandoUsuario) {
        Paciente usuario = this.fabricaUsuario.crear(comandoUsuario);
        return new ComandoRespuesta<>(this.servicioCrearUsuario.ejecutar(usuario));
    }
}
