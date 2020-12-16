package com.ceiba.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class Cita {
	
	private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_LA_CITA = "Se debe ingresar la fecha de la cita";
	private static final String SE_DEBE_SELECCIONAR_EL_USUARIO = "Se debe seleccionar el usuario";
	private static final String SE_DEBE_SELECCIONAR_EL_MEDICO = "Se debe seleccionar el m\u00e9dico";
	
	private Long id;
	private LocalDateTime fechaCita;
	private Long idPaciente;
	private Long idMedico;
	
	public Cita(Long id, LocalDateTime fechaCita, Long idPaciente, Long idMedico) {
		validarObligatorio(fechaCita, SE_DEBE_INGRESAR_LA_FECHA_DE_LA_CITA);
		validarObligatorio(idPaciente, SE_DEBE_SELECCIONAR_EL_USUARIO);
		validarObligatorio(idMedico, SE_DEBE_SELECCIONAR_EL_MEDICO);
		
		this.id = id;
		this.fechaCita = fechaCita;
		this.idPaciente = idPaciente;
		this.idMedico = idMedico;
	}

}
