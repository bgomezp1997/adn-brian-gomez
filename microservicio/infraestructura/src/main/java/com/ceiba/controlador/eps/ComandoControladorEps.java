package com.ceiba.controlador.eps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comando.ComandoEps;
import com.ceiba.comando.manejador.eps.ManejadorActualizarEps;
import com.ceiba.comando.manejador.eps.ManejadorCrearEps;
import com.ceiba.comando.manejador.eps.ManejadorEliminarEps;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/eps")
@Api(tags = { "Controlador comando eps" })
public class ComandoControladorEps {

	private final ManejadorCrearEps manejadorCrearEps;
	private final ManejadorEliminarEps manejadorEliminarEps;
	private final ManejadorActualizarEps manejadorActualizarEps;

	@Autowired
	public ComandoControladorEps(ManejadorCrearEps manejadorCrearEps,
			ManejadorEliminarEps manejadorEliminarEps, ManejadorActualizarEps manejadorActualizarEps) {
		this.manejadorCrearEps = manejadorCrearEps;
		this.manejadorEliminarEps = manejadorEliminarEps;
		this.manejadorActualizarEps = manejadorActualizarEps;
	}

	@PostMapping
	@ApiOperation("Crear Eps")
	public ComandoRespuesta<Long> crear(@RequestBody ComandoEps comandoEps) {
		return manejadorCrearEps.ejecutar(comandoEps);
	}

	@DeleteMapping(value = "/{id}")
	@ApiOperation("Eliminar Eps")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarEps.ejecutar(id);
	}

	@PutMapping(value = "/{id}")
	@ApiOperation("Actualizar Eps")
	public void actualizar(@RequestBody ComandoEps comandoEps, @PathVariable Long id) {
		comandoEps.setId(id);
		manejadorActualizarEps.ejecutar(comandoEps);
	}
}
