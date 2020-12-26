package com.ceiba.servicio.usuario;

import static org.junit.Assert.assertNotNull;

import java.util.NoSuchElementException;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UserDetails;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionAutenticacion;
import com.ceiba.puerto.dao.DaoUsuario;
import com.ceiba.util.builder.DtoUsuarioTestDataBuilder;

public class ServicioUserDetailTest {

	@Test
	@SuppressWarnings("unchecked")
    public void validarUsuarioExistenciaPreviaTest() {
    	String username = "brian";
        
    	DaoUsuario daoUsuario = Mockito.mock(DaoUsuario.class);
        Mockito.when(daoUsuario.obtenerPorUsername(Mockito.anyString())).thenThrow(NoSuchElementException.class);
        ServicioUserDetail servicioUserDetail = new ServicioUserDetail(daoUsuario);
        
        BasePrueba.assertThrows(() -> servicioUserDetail.loadUserByUsername(username), ExcepcionAutenticacion.class,"Hubo un error en la autenticacion del usuario. Usuario o contraseña incorrectos.");
    }
    
    @Test
    public void ejecutarTodoValido() {
    	String username = "brian";
        
    	DaoUsuario daoUsuario = Mockito.mock(DaoUsuario.class);
        Mockito.when(daoUsuario.obtenerPorUsername(Mockito.anyString())).thenReturn(new DtoUsuarioTestDataBuilder().build());
        ServicioUserDetail servicioUserDetail = new ServicioUserDetail(daoUsuario);
        UserDetails userDetails = servicioUserDetail.loadUserByUsername(username);
       
        assertNotNull(userDetails);
    }
}
