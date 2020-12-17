package com.ceiba.servicio.medico;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Medico;
import com.ceiba.puerto.repositorio.RepositorioMedico;

public class ServicioCrearMedico {
	
	private static final String EL_MEDICO_YA_EXISTE_EN_EL_SISTEMA = "El medico ya existe en el sistema";

    private final RepositorioMedico repositorioMedico;

    public ServicioCrearMedico(RepositorioMedico repositorioMedico) {
        this.repositorioMedico = repositorioMedico;
    }

    public Long ejecutar(Medico medico) {
        validarExistenciaPrevia(medico);
        return this.repositorioMedico.crear(medico);
    }

    private void validarExistenciaPrevia(Medico medico) {
        boolean existe = this.repositorioMedico.existe(medico.getIdentificacion());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_MEDICO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

}
