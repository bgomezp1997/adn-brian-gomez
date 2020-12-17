package com.ceiba.comando.manejador.medico;

import org.springframework.stereotype.Component;
import com.ceiba.ComandoRespuesta;
import com.ceiba.comando.ComandoMedico;
import com.ceiba.comando.fabrica.FabricaMedico;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.modelo.entidad.Medico;
import com.ceiba.servicio.medico.ServicioCrearMedico;

@Component
public class ManejadorCrearMedico implements ManejadorComandoRespuesta<ComandoMedico, ComandoRespuesta<Long>> {

    private final FabricaMedico fabricaMedico;
    private final ServicioCrearMedico servicioCrearMedico;

    public ManejadorCrearMedico(FabricaMedico fabricaMedico, ServicioCrearMedico servicioCrearMedico) {
        this.fabricaMedico = fabricaMedico;
        this.servicioCrearMedico = servicioCrearMedico;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoMedico comandoMedico) {
        Medico medico = this.fabricaMedico.crear(comandoMedico);
        return new ComandoRespuesta<>(this.servicioCrearMedico.ejecutar(medico));
    }
}
