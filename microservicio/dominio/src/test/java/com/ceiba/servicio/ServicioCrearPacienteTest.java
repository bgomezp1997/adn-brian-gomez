package com.ceiba.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Paciente;
import com.ceiba.puerto.repositorio.RepositorioPaciente;
import com.ceiba.servicio.testdatabuilder.PacienteTestDataBuilder;

public class ServicioCrearPacienteTest {

//    @Test
//    public void validarClaveLongitudMenor4Test() {
//        // arrange
//        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conClave("124");
//        // act - assert
//        BasePrueba.assertThrows(() -> usuarioTestDataBuilder.build(), ExcepcionLongitudValor.class, "La clave debe tener una longitud mayor o igual a 4");
//    }

    @Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
        Paciente usuario = new PacienteTestDataBuilder().build();
        RepositorioPaciente repositorioUsuario = Mockito.mock(RepositorioPaciente.class);
        Mockito.when(repositorioUsuario.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearPaciente servicioCrearUsuario = new ServicioCrearPaciente(repositorioUsuario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearUsuario.ejecutar(usuario), ExcepcionDuplicidad.class, "El paciente ya existe en el sistema");
    }
}
