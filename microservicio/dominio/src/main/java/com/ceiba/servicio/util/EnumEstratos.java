package com.ceiba.servicio.util;

import lombok.Getter;

public enum EnumEstratos {
	
	ESTRATO_UNO(1), 
	ESTRATO_DOS(2), 
	ESTRATO_TRES(3), 
	ESTRATO_CUATRO(4), 
	ESTRATO_CINCO(5);
	
	@Getter
	private Integer value;
	
	private EnumEstratos(Integer value) {
		this.value = value;
	}

}
