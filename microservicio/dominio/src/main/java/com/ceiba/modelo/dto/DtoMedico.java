package com.ceiba.modelo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoMedico {
	
	private Long id;
	private String nombres;
	private String apellidos;
	private LocalDateTime fechaCreacion;
	private String identificacion;
	private String email;
	private String especialidad;
	private String numeroTarjetaProfesional;

}
