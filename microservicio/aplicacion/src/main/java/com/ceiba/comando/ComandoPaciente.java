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
public class ComandoPaciente {

	private Long id;
	private String nombres;
	private String apellidos;
	private LocalDateTime fechaCreacion;
	private String identificacion;
	private String email;
    private Long idEps;
    private String estrato;
}
