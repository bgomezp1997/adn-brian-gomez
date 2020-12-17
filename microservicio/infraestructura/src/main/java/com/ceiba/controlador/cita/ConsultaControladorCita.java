package com.ceiba.controlador.cita;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.consulta.ManejadorListarCitas;
import com.ceiba.modelo.dto.DtoCita;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cita")
@Api(tags={"Controlador consulta cita"})
public class ConsultaControladorCita {

    private final ManejadorListarCitas manejadorListarCita;

    public ConsultaControladorCita(ManejadorListarCitas manejadorListarCita) {
        this.manejadorListarCita = manejadorListarCita;
    }

    @GetMapping
    @ApiOperation("Listar Citas")
    public List<DtoCita> listar() {
        return this.manejadorListarCita.ejecutar();
    }

}
