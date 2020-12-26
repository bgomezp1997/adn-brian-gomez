package com.ceiba.servicio.cita;

import static org.mockito.Mockito.verify;

import java.io.IOException;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionCitasExcedidas;
import com.ceiba.dominio.excepcion.ExcepcionDiaNoLaborable;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Cita;
import com.ceiba.puerto.repositorio.RepositorioCita;
import com.ceiba.util.builder.CitaTestDataBuilder;
import com.ceiba.util.premock.MockCache;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class ServicioCrearCitaTest {

    @Test
    public void validarUsuarioExistenciaPreviaTest() throws JsonParseException, JsonMappingException, IOException {
    	MockCache.mockParametros(Boolean.TRUE);
    	
    	Cita cita = new CitaTestDataBuilder().build();
    	RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        Mockito.when(repositorioCita.existe(Mockito.any(), Mockito.anyLong(), Mockito.anyLong())).thenReturn(true);
        ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita);
        
        BasePrueba.assertThrows(() -> servicioCrearCita.ejecutar(cita), ExcepcionDuplicidad.class, "La cita ya existe en el sistema");
    }
    
    @Test
    public void validarCitaConTopeDeCitas() throws JsonParseException, JsonMappingException, IOException {
    	MockCache.mockParametros(Boolean.TRUE);
    	
        Cita cita = new CitaTestDataBuilder().conId(1L).build();
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        Mockito.when(repositorioCita.existe(Mockito.any(), Mockito.anyLong(), Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioCita.contarCitasPorDia(Mockito.any())).thenReturn(5);
        ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita);
        
        BasePrueba.assertThrows(() -> servicioCrearCita.ejecutar(cita), ExcepcionCitasExcedidas.class, "No se pueden hacer mas citas por el dia de hoy");
    }
    
    @Test
    public void validarCitaSiendoUnDomingo() throws JsonParseException, JsonMappingException, IOException {
    	MockCache.mockParametros(Boolean.TRUE);
    	
        Cita cita = new CitaTestDataBuilder().conId(1L).siendoDomingo().build();
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        Mockito.when(repositorioCita.existe(Mockito.any(), Mockito.anyLong(), Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioCita.contarCitasPorDia(Mockito.any())).thenReturn(1);
        ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita);
        
        BasePrueba.assertThrows(() -> servicioCrearCita.ejecutar(cita), ExcepcionDiaNoLaborable.class, "No se pueden agendar citas los domingos");
    }
    
    @Test
    public void validarCitaSiendoUnFestivo() throws JsonParseException, JsonMappingException, IOException {
    	MockCache.mockParametros(Boolean.TRUE);
    	
        Cita cita = new CitaTestDataBuilder().conId(1L).siendoFestivo().build();
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        Mockito.when(repositorioCita.existe(Mockito.any(), Mockito.anyLong(), Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioCita.contarCitasPorDia(Mockito.any())).thenReturn(1);
        ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita);
        
        BasePrueba.assertThrows(() -> servicioCrearCita.ejecutar(cita), ExcepcionDiaNoLaborable.class, "No se pueden agendar citas los dias festivos");
    }
    
    @Test
    public void ejecutarTodoValido() throws JsonParseException, JsonMappingException, IOException {
    	MockCache.mockParametros(Boolean.TRUE);
    	
    	Cita cita = new CitaTestDataBuilder().conId(1L).build();
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        Mockito.when(repositorioCita.existe(Mockito.any(), Mockito.anyLong(), Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioCita.contarCitasPorDia(Mockito.any())).thenReturn(1);
        ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita);
        servicioCrearCita.ejecutar(cita);
        
        verify(repositorioCita).crear(cita);
    }
}
