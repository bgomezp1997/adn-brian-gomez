package com.ceiba.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.consulta.ManejadorListarPacientes;
import com.ceiba.modelo.dto.DtoPaciente;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/paciente")
@Api(tags={"Controlador consulta paciente"})
public class ConsultaControladorPaciente {

    private final ManejadorListarPacientes manejadorListarUsuarios;

    public ConsultaControladorPaciente(ManejadorListarPacientes manejadorListarUsuarios) {
        this.manejadorListarUsuarios = manejadorListarUsuarios;
    }

    @GetMapping
    @ApiOperation("Listar Pacientes")
    public List<DtoPaciente> listar() {
        return this.manejadorListarUsuarios.ejecutar();
    }

}
