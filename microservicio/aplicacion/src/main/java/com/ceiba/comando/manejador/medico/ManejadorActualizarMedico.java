package com.ceiba.comando.manejador.medico;

import org.springframework.stereotype.Component;

import com.ceiba.comando.ComandoMedico;
import com.ceiba.comando.fabrica.FabricaMedico;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.modelo.entidad.Medico;
import com.ceiba.servicio.medico.ServicioActualizarMedico;

@Component
public class ManejadorActualizarMedico implements ManejadorComando<ComandoMedico> {

    private final FabricaMedico fabricaMedico;
    private final ServicioActualizarMedico servicioActualizarMedico;

    public ManejadorActualizarMedico(FabricaMedico fabricaMedico, ServicioActualizarMedico servicioActualizarMedico) {
        this.fabricaMedico = fabricaMedico;
        this.servicioActualizarMedico = servicioActualizarMedico;
    }

    public void ejecutar(ComandoMedico comandoMedico) {
        Medico medico = this.fabricaMedico.crear(comandoMedico);
        this.servicioActualizarMedico.ejecutar(medico);
    }
}
