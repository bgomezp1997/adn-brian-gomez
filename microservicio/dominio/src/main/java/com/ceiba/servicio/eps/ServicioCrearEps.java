package com.ceiba.servicio.eps;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Eps;
import com.ceiba.puerto.repositorio.RepositorioEps;

public class ServicioCrearEps {
	
	private static final String LA_EPS_YA_EXISTE_EN_EL_SISTEMA = "La eps ya existe en el sistema";

    private final RepositorioEps repositorioEps;

    public ServicioCrearEps(RepositorioEps repositorioEps) {
        this.repositorioEps = repositorioEps;
    }

    public Long ejecutar(Eps eps) {
        validarExistenciaPrevia(eps);
        return this.repositorioEps.crear(eps);
    }

    private void validarExistenciaPrevia(Eps eps) {
        boolean existe = this.repositorioEps.existe(eps.getNit());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_EPS_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

}
