package com.ceiba.modelo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoCita {
	
	private Long id;
	private LocalDateTime fechaCita;
	private DtoPaciente paciente;
	private DtoMedico medico;

}
