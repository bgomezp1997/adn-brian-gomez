package com.ceiba.servicio.eps;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Eps;
import com.ceiba.puerto.repositorio.RepositorioEps;

public class ServicioActualizarEps {

    private static final String LA_EPS_YA_EXISTE_EN_EL_SISTEMA = "La eps ya existe en el sistema";

    private final RepositorioEps repositorioEps;

    public ServicioActualizarEps(RepositorioEps repositorioEps) {
        this.repositorioEps = repositorioEps;
    }

    public void ejecutar(Eps eps) {
        validarExistenciaPrevia(eps);
        this.repositorioEps.actualizar(eps);
    }

    private void validarExistenciaPrevia(Eps eps) {
        boolean existe = this.repositorioEps.existeExcluyendoId(eps.getId(), eps.getNit());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_EPS_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
