package com.ceiba.modelo.util;

import lombok.Getter;

public enum EnumTipoParametro {
	
	GENERAL(1), FESTIVO(2);
	
	@Getter
	private Integer indicative;
	
	private EnumTipoParametro(Integer indicative) {
		this.indicative = indicative;
	}

}
