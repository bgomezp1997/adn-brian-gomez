package com.ceiba.servicio;

import com.ceiba.puerto.repositorio.RepositorioPaciente;

public class ServicioEliminarPaciente {

    private final RepositorioPaciente repositorioUsuario;

    public ServicioEliminarPaciente(RepositorioPaciente repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public void ejecutar(Long id) {
        this.repositorioUsuario.eliminar(id);
    }
}
