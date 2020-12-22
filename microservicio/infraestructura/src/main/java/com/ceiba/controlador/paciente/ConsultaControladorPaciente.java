package com.ceiba.controlador.paciente;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.consulta.ManejadorListarPacientes;
import com.ceiba.modelo.dto.DtoPaciente;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/paciente")
@Api(tags={"Controlador consulta paciente"})
public class ConsultaControladorPaciente {

    private final ManejadorListarPacientes manejadorListarPacientes;

    public ConsultaControladorPaciente(ManejadorListarPacientes manejadorListarPacientes) {
        this.manejadorListarPacientes = manejadorListarPacientes;
    }

    @GetMapping
    @ApiOperation("Listar Pacientes")
    public List<DtoPaciente> listar() {
        return this.manejadorListarPacientes.ejecutar();
    }

}
