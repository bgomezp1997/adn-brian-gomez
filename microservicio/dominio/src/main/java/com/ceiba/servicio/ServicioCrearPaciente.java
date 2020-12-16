package com.ceiba.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Paciente;
import com.ceiba.puerto.repositorio.RepositorioPaciente;


public class ServicioCrearPaciente {

    private static final String EL_PACIENTE_YA_EXISTE_EN_EL_SISTEMA = "El paciente ya existe en el sistema";

    private final RepositorioPaciente repositorioUsuario;

    public ServicioCrearPaciente(RepositorioPaciente repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Long ejecutar(Paciente paciente) {
        validarExistenciaPrevia(paciente);
        return this.repositorioUsuario.crear(paciente);
    }

    private void validarExistenciaPrevia(Paciente paciente) {
        boolean existe = this.repositorioUsuario.existe(paciente.getIdentificacion());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_PACIENTE_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
