package com.ceiba.controlador.eps;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.consulta.ManejadorListarEps;
import com.ceiba.modelo.dto.DtoEps;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/eps")
@Api(tags={"Controlador consulta eps"})
public class ConsultaControladorEps {

    private final ManejadorListarEps manejadorListarEps;

    public ConsultaControladorEps(ManejadorListarEps manejadorListarEps) {
        this.manejadorListarEps = manejadorListarEps;
    }

    @GetMapping
    @ApiOperation("Listar Eps")
    public List<DtoEps> listar() {
        return this.manejadorListarEps.ejecutar();
    }

}
