package com.ceiba.servicio.eps;

import com.ceiba.puerto.repositorio.RepositorioEps;

public class ServicioEliminarEps {

    private final RepositorioEps repositorioEps;

    public ServicioEliminarEps(RepositorioEps repositorioEps) {
        this.repositorioEps = repositorioEps;
    }

    public void ejecutar(Long id) {
        this.repositorioEps.eliminar(id);
    }
}
