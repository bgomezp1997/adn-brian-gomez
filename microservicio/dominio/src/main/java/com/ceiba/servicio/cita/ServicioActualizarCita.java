package com.ceiba.servicio.cita;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Cita;
import com.ceiba.puerto.repositorio.RepositorioCita;

public class ServicioActualizarCita {

    private static final String LA_CITA_YA_EXISTE_EN_EL_SISTEMA = "La cita ya existe en el sistema";

    private final RepositorioCita repositorioCita;

    public ServicioActualizarCita(RepositorioCita repositorioCita) {
        this.repositorioCita = repositorioCita;
    }

    public void ejecutar(Cita cita) {
        validarExistenciaPrevia(cita);
        this.repositorioCita.actualizar(cita);
    }

    private void validarExistenciaPrevia(Cita cita) {
        boolean existe = this.repositorioCita.existeExcluyendoId(cita.getId(), cita.getFechaCita(), cita.getIdPaciente(), cita.getIdMedico());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_CITA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
