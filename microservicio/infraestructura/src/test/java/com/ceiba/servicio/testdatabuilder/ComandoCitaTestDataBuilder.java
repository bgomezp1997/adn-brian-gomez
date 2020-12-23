package com.ceiba.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.comando.ComandoCita;
import com.ceiba.comando.ComandoMedico;
import com.ceiba.comando.ComandoPaciente;

public class ComandoCitaTestDataBuilder {

	private Long id;
    private LocalDateTime fechaCreacion;
    private Long idPaciente;
    private Long idMedico;
    private Double precio;

    public ComandoCitaTestDataBuilder() {
    	idPaciente = 2L;
    	idMedico = 1L;
    	precio = 2D;
        fechaCreacion = LocalDateTime.now();
    }

    public ComandoCita build() {
    	ComandoPaciente comandoPaciente = new ComandoPaciente();
    	ComandoMedico comandoMedico = new ComandoMedico();
    	comandoPaciente.setId(idPaciente);
    	comandoMedico.setId(idMedico);
        return new ComandoCita(id, fechaCreacion, comandoPaciente, comandoMedico, precio);
    }
}
