package com.ceiba.controlador.paciente;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.consulta.paciente.ManejadorListarPacientes;
import com.ceiba.consulta.paciente.ManejadorObtenerPaciente;
import com.ceiba.modelo.dto.DtoPaciente;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/paciente")
@Api(tags={"Controlador consulta paciente"})
public class ConsultaControladorPaciente {

    private final ManejadorListarPacientes manejadorListarPacientes;
    private final ManejadorObtenerPaciente manejadorObtenerPaciente;

    public ConsultaControladorPaciente(ManejadorListarPacientes manejadorListarPacientes, ManejadorObtenerPaciente manejadorObtenerPaciente) {
        this.manejadorListarPacientes = manejadorListarPacientes;
        this.manejadorObtenerPaciente = manejadorObtenerPaciente;
    }
    
    @GetMapping(value = "/{id}")
    @ApiOperation("Obtener Paciente")
    public DtoPaciente obtener(@PathVariable Long id) {
    	return this.manejadorObtenerPaciente.ejecutar(id);
    }

    @GetMapping
    @ApiOperation("Listar Pacientes")
    public List<DtoPaciente> listar() {
        return this.manejadorListarPacientes.ejecutar();
    }

}
