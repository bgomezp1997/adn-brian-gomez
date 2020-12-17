package com.ceiba.controlador.medico;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.consulta.ManejadorListarMedicos;
import com.ceiba.modelo.dto.DtoMedico;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/medico")
@Api(tags={"Controlador consulta medico"})
public class ConsultaControladorMedico {

    private final ManejadorListarMedicos manejadorListarMedicos;

    public ConsultaControladorMedico(ManejadorListarMedicos manejadorListarMedicos) {
        this.manejadorListarMedicos = manejadorListarMedicos;
    }

    @GetMapping
    @ApiOperation("Listar Medicos")
    public List<DtoMedico> listar() {
        return this.manejadorListarMedicos.ejecutar();
    }

}
