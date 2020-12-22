package com.ceiba.controlador.cita;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.consulta.cita.ManejadorListarCitas;
import com.ceiba.consulta.cita.ManejadorObtenerCita;
import com.ceiba.modelo.dto.DtoCita;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cita")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Api(tags={"Controlador consulta cita"})
public class ConsultaControladorCita {

    private final ManejadorListarCitas manejadorListarCita;
    private final ManejadorObtenerCita manejadorObtenerCita;

    public ConsultaControladorCita(ManejadorListarCitas manejadorListarCita, ManejadorObtenerCita manejadorObtenerCita) {
        this.manejadorListarCita = manejadorListarCita;
        this.manejadorObtenerCita = manejadorObtenerCita;
    }
    
    @GetMapping(value = "/{id}")
    @ApiOperation("Listar Citas")
    public DtoCita obtener(@PathVariable Long id) {
    	return this.manejadorObtenerCita.ejecutar(id);
    }

    @GetMapping
    @ApiOperation("Listar Citas")
    public List<DtoCita> listar() {
        return this.manejadorListarCita.ejecutar();
    }

}
