package com.ceiba.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Paciente;
import com.ceiba.puerto.repositorio.RepositorioPaciente;

public class ServicioActualizarPaciente {

    private static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El usuario ya existe en el sistema";

    private final RepositorioPaciente repositorioUsuario;

    public ServicioActualizarPaciente(RepositorioPaciente repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public void ejecutar(Paciente paciente) {
        validarExistenciaPrevia(paciente);
        this.repositorioUsuario.actualizar(paciente);
    }

    private void validarExistenciaPrevia(Paciente paciente) {
        boolean existe = this.repositorioUsuario.existeExcluyendoId(paciente.getId(), paciente.getIdentificacion());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
