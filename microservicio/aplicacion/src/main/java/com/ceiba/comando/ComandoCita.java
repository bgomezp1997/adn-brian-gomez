package com.ceiba.comando;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCita {

	private Long id;
	private LocalDateTime fechaCita;
	private Long idPaciente;
	private Long idMedico;
	
}
