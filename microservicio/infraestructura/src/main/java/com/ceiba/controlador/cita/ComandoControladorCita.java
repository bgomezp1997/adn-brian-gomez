package com.ceiba.controlador.cita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comando.ComandoCita;
import com.ceiba.comando.manejador.cita.ManejadorActualizarCita;
import com.ceiba.comando.manejador.cita.ManejadorCrearCita;
import com.ceiba.comando.manejador.cita.ManejadorEliminarCita;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/cita")
@Api(tags = { "Controlador comando cita" })
public class ComandoControladorCita {

	private final ManejadorCrearCita manejadorCrearCita;
	private final ManejadorEliminarCita manejadorEliminarCita;
	private final ManejadorActualizarCita manejadorActualizarCita;

	@Autowired
	public ComandoControladorCita(ManejadorCrearCita manejadorCrearCita,
			ManejadorEliminarCita manejadorEliminarCita, ManejadorActualizarCita manejadorActualizarCita) {
		this.manejadorCrearCita = manejadorCrearCita;
		this.manejadorEliminarCita = manejadorEliminarCita;
		this.manejadorActualizarCita = manejadorActualizarCita;
	}

	@PostMapping
	@ApiOperation("Crear Cita")
	public ComandoRespuesta<Long> crear(@RequestBody ComandoCita comandoCita) {
		return manejadorCrearCita.ejecutar(comandoCita);
	}

	@DeleteMapping(value = "/{id}")
	@ApiOperation("Eliminar Cita")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarCita.ejecutar(id);
	}

	@PutMapping(value = "/{id}")
	@ApiOperation("Actualizar Cita")
	public void actualizar(@RequestBody ComandoCita comandoCita, @PathVariable Long id) {
		comandoCita.setId(id);
		manejadorActualizarCita.ejecutar(comandoCita);
	}
}
