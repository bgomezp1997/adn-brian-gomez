package com.ceiba.controlador.parametro;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.consulta.parametro.ManejadorListarParametros;
import com.ceiba.modelo.dto.DtoParametro;
import com.ceiba.modelo.util.EnumTipoParametro;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/parametro")
@Api(tags={"Controlador consulta parametro"})
public class ConsultaControladorParametro {

    private final ManejadorListarParametros manejadorListarParametros;

    public ConsultaControladorParametro(ManejadorListarParametros manejadorListarParametros) {
        this.manejadorListarParametros = manejadorListarParametros;
    }
    
    @GetMapping
    @ApiOperation("Obtener Parametro")
    public List<DtoParametro> obtener(@RequestParam("estado") Boolean estado, @RequestParam("tipo") EnumTipoParametro enumTipoParametro) {
    	return this.manejadorListarParametros.ejecutar(estado, enumTipoParametro);
    }

}