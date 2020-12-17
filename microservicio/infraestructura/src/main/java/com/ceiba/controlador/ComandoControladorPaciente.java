package com.ceiba.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comando.ComandoPaciente;
import com.ceiba.comando.manejador.paciente.ManejadorActualizarPaciente;
import com.ceiba.comando.manejador.paciente.ManejadorCrearPaciente;
import com.ceiba.comando.manejador.paciente.ManejadorEliminarPaciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/paciente")
@Api(tags = { "Controlador comando paciente"})
public class ComandoControladorPaciente {

    private final ManejadorCrearPaciente manejadorCrearPaciente;
	private final ManejadorEliminarPaciente manejadorEliminarPaciente;
	private final ManejadorActualizarPaciente manejadorActualizarPaciente;

    @Autowired
    public ComandoControladorPaciente(ManejadorCrearPaciente manejadorCrearPaciente,
									 ManejadorEliminarPaciente manejadorEliminarPaciente,
									 ManejadorActualizarPaciente manejadorActualizarPaciente) {
        this.manejadorCrearPaciente = manejadorCrearPaciente;
		this.manejadorEliminarPaciente = manejadorEliminarPaciente;
		this.manejadorActualizarPaciente = manejadorActualizarPaciente;
    }

    @PostMapping
    @ApiOperation("Crear Paciente")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoPaciente comandoPaciente) {
        return manejadorCrearPaciente.ejecutar(comandoPaciente);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Paciente")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarPaciente.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar paciente")
	public void actualizar(@RequestBody ComandoPaciente comandoPaciente,@PathVariable Long id) {
		comandoPaciente.setId(id);
		manejadorActualizarPaciente.ejecutar(comandoPaciente);
	}
}
