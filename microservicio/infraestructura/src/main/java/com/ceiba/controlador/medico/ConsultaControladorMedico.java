package com.ceiba.controlador.medico;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.consulta.medico.ManejadorListarMedicos;
import com.ceiba.consulta.medico.ManejadorObtenerMedico;
import com.ceiba.modelo.dto.DtoMedico;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/medico")
@Api(tags={"Controlador consulta medico"})
public class ConsultaControladorMedico {

    private final ManejadorListarMedicos manejadorListarMedicos;
    private final ManejadorObtenerMedico manejadorObtenerMedico;

    public ConsultaControladorMedico(ManejadorListarMedicos manejadorListarMedicos, ManejadorObtenerMedico manejadorObtenerMedico) {
        this.manejadorListarMedicos = manejadorListarMedicos;
        this.manejadorObtenerMedico = manejadorObtenerMedico;
    }
    
    @GetMapping(value = "/{id}")
    @ApiOperation("Obtener Medico")
    public DtoMedico obtener(@PathVariable Long id) {
    	return this.manejadorObtenerMedico.ejecutar(id);
    }

    @GetMapping
    @ApiOperation("Listar Medicos")
    public List<DtoMedico> listar() {
        return this.manejadorListarMedicos.ejecutar();
    }

}
