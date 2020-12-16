package com.ceiba.modelo.util;

import lombok.Getter;

public enum EnumParametro {
	
	VALOR_CITA(1);
	
	@Getter
	private Integer indicative;
	
	private EnumParametro(Integer indicative) {
		this.indicative = indicative;
	}

}
