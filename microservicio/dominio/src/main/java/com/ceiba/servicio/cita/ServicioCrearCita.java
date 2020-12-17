package com.ceiba.servicio.cita;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Cita;
import com.ceiba.puerto.repositorio.RepositorioCita;

public class ServicioCrearCita {
	
	private static final String LA_CITA_YA_EXISTE_EN_EL_SISTEMA = "La cita ya existe en el sistema";

    private final RepositorioCita repositorioCita;

    public ServicioCrearCita(RepositorioCita repositorioCita) {
        this.repositorioCita = repositorioCita;
    }

    public Long ejecutar(Cita cita) {
        validarExistenciaPrevia(cita);
        return this.repositorioCita.crear(cita);
    }

    private void validarExistenciaPrevia(Cita cita) {
        boolean existe = this.repositorioCita.existe(cita.getFechaCita(), cita.getIdPaciente(), cita.getIdMedico());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_CITA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

}
