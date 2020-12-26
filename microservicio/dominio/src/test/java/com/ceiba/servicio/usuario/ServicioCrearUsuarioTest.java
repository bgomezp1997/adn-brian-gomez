package com.ceiba.servicio.usuario;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Usuario;
import com.ceiba.puerto.repositorio.RepositorioUsuario;
import com.ceiba.util.builder.UsuarioTestDataBuilder;

public class ServicioCrearUsuarioTest {

    @Test
    public void validarUsuarioExistenciaPreviaTest() {
     
    	Usuario usuario = new UsuarioTestDataBuilder().build();
    	RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearUsuario servicioCrearUsuario = new ServicioCrearUsuario(repositorioUsuario);
       
        BasePrueba.assertThrows(() -> servicioCrearUsuario.ejecutar(usuario), ExcepcionDuplicidad.class, "El usuario ya existe en el sistema");
    }
    
    @Test
    public void ejecutarTodoValido() {
    	Usuario usuario = new UsuarioTestDataBuilder().build();
    	RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.existe(Mockito.anyString())).thenReturn(false);
        ServicioCrearUsuario servicioCrearUsuario = new ServicioCrearUsuario(repositorioUsuario);
        servicioCrearUsuario.ejecutar(usuario);
        
        verify(repositorioUsuario).crear(usuario);
    }
}
