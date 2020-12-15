package com.ceiba.usuario.modelo.dto;

import com.ceiba.usuario.modelo.util.EnumParametro;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoParametro {
	
    private Long id;
    private EnumParametro nombre;
    private String valor;
    private Boolean estado;

}
