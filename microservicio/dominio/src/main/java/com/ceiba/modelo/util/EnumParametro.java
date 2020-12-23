package com.ceiba.modelo.util;

import lombok.Getter;

public enum EnumParametro {
	
	VALOR_CITA(1), 
	CANTIDAD_CITAS_DIA(2), 
	NAVIDAD(3), 
	ANO_NUEVO(4), 
	DSCTO_ESTRATO_BAJO(5), 
	DSCTO_ESTRATO_MEDIO(6), 
	DSCTO_ESTRATO_ALTO(7), 
	CORNEOLOGO(8), 
	RETINOLOGO(9), 
	GLAUCOMATOLOGO(10),
	OCULOPLASTICO(11),
	NO(12);
	
	@Getter
	private Integer indicative;
	
	private EnumParametro(Integer indicative) {
		this.indicative = indicative;
	}

}
