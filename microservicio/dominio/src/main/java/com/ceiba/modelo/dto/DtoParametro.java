package com.ceiba.modelo.dto;

import java.io.Serializable;

import com.ceiba.modelo.util.EnumParametro;
import com.ceiba.modelo.util.EnumTipoParametro;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoParametro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private EnumParametro nombre;
    private EnumTipoParametro tipo;
    private String valor;
    private Boolean estado;

}
