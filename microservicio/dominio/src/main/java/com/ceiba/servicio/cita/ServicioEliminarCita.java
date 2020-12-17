package com.ceiba.servicio.cita;

import com.ceiba.puerto.repositorio.RepositorioCita;

public class ServicioEliminarCita {

    private final RepositorioCita repositorioCita;

    public ServicioEliminarCita(RepositorioCita repositorioCita) {
        this.repositorioCita = repositorioCita;
    }

    public void ejecutar(Long id) {
        this.repositorioCita.eliminar(id);
    }
}
