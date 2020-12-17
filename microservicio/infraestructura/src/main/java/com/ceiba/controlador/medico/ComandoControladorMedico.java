package com.ceiba.controlador.medico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comando.ComandoMedico;
import com.ceiba.comando.manejador.medico.ManejadorActualizarMedico;
import com.ceiba.comando.manejador.medico.ManejadorCrearMedico;
import com.ceiba.comando.manejador.medico.ManejadorEliminarMedico;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/medico")
@Api(tags = { "Controlador comando medico" })
public class ComandoControladorMedico {

	private final ManejadorCrearMedico manejadorCrearMedico;
	private final ManejadorEliminarMedico manejadorEliminarMedico;
	private final ManejadorActualizarMedico manejadorActualizarMedico;

	@Autowired
	public ComandoControladorMedico(ManejadorCrearMedico manejadorCrearMedico,
			ManejadorEliminarMedico manejadorEliminarMedico, ManejadorActualizarMedico manejadorActualizarMedico) {
		this.manejadorCrearMedico = manejadorCrearMedico;
		this.manejadorEliminarMedico = manejadorEliminarMedico;
		this.manejadorActualizarMedico = manejadorActualizarMedico;
	}

	@PostMapping
	@ApiOperation("Crear Medico")
	public ComandoRespuesta<Long> crear(@RequestBody ComandoMedico comandoMedico) {
		return manejadorCrearMedico.ejecutar(comandoMedico);
	}

	@DeleteMapping(value = "/{id}")
	@ApiOperation("Eliminar Medico")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarMedico.ejecutar(id);
	}

	@PutMapping(value = "/{id}")
	@ApiOperation("Actualizar Medico")
	public void actualizar(@RequestBody ComandoMedico comandoMedico, @PathVariable Long id) {
		comandoMedico.setId(id);
		manejadorActualizarMedico.ejecutar(comandoMedico);
	}
}
