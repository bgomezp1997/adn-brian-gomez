package com.ceiba.controlador.eps;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.consulta.eps.ManejadorListarEps;
import com.ceiba.consulta.eps.ManejadorObtenerEps;
import com.ceiba.modelo.dto.DtoEps;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/eps")
@Api(tags={"Controlador consulta eps"})
public class ConsultaControladorEps {

    private final ManejadorListarEps manejadorListarEps;
    private final ManejadorObtenerEps manejadorObtenerEps;

    public ConsultaControladorEps(ManejadorListarEps manejadorListarEps, ManejadorObtenerEps manejadorObtenerEps) {
        this.manejadorListarEps = manejadorListarEps;
        this.manejadorObtenerEps = manejadorObtenerEps;
    }
    
    @GetMapping(value = "/{id}")
    @ApiOperation("Obtener Eps")
    public DtoEps obtener(@PathVariable Long id) {
    	return this.manejadorObtenerEps.ejecutar(id);
    }

    @GetMapping
    @ApiOperation("Listar Eps")
    public List<DtoEps> listar() {
        return this.manejadorListarEps.ejecutar();
    }

}
