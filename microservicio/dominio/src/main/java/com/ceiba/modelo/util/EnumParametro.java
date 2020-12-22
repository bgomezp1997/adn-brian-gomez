package com.ceiba.modelo.util;

import lombok.Getter;

public enum EnumParametro {
	
	VALOR_CITA(1), CANTIDAD_CITAS_DIA(2), NAVIDAD(3), ANO_NUEVO(4);
	
	@Getter
	private Integer indicative;
	
	private EnumParametro(Integer indicative) {
		this.indicative = indicative;
	}

}
