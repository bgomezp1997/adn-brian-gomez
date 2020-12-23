package com.ceiba.servicio.cita;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionCitasExcedidas;
import com.ceiba.dominio.excepcion.ExcepcionDiaNoLaborable;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.dto.DtoParametro;
import com.ceiba.modelo.entidad.Cita;
import com.ceiba.modelo.util.EnumParametro;
import com.ceiba.modelo.util.EnumTipoParametro;
import com.ceiba.puerto.repositorio.RepositorioCita;
import com.ceiba.servicio.testdatabuilder.CitaTestDataBuilder;

public class ServicioActualizarCitaTest {

    @Test
    public void validarPacienteConExistenciaTest() {
    	
        Cita cita = new CitaTestDataBuilder().conId(1L).build();
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        Mockito.when(repositorioCita.existeExcluyendoId(Mockito.anyLong(), Mockito.any(), Mockito.anyLong(), Mockito.anyLong())).thenReturn(true);
        ServicioActualizarCita servicioActualizarCita = new ServicioActualizarCita(repositorioCita);
        
        BasePrueba.assertThrows(() -> servicioActualizarCita.ejecutar(cita, 5, null), ExcepcionDuplicidad.class, "La cita ya existe en el sistema");
    }
    
    @Test
    public void validarPacienteConTopeDeCitas() {
    	
        Cita cita = new CitaTestDataBuilder().conId(1L).build();
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        Mockito.when(repositorioCita.existeExcluyendoId(Mockito.anyLong(), Mockito.any(), Mockito.anyLong(), Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioCita.existe(Mockito.any(), Mockito.anyLong(), Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioCita.contarCitasPorDia(Mockito.any())).thenReturn(5);
        ServicioActualizarCita servicioActualizarCita = new ServicioActualizarCita(repositorioCita);
        
        BasePrueba.assertThrows(() -> servicioActualizarCita.ejecutar(cita, 5, null), ExcepcionCitasExcedidas.class, "No se pueden hacer mas citas por el dia de hoy");
    }
    
    @Test
    public void validarPacienteSiendoUnDomingo() {
    	
        Cita cita = new CitaTestDataBuilder().conId(1L).siendoDomingo().build();
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        Mockito.when(repositorioCita.existeExcluyendoId(Mockito.anyLong(), Mockito.any(), Mockito.anyLong(), Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioCita.existe(Mockito.any(), Mockito.anyLong(), Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioCita.contarCitasPorDia(Mockito.any())).thenReturn(1);
        ServicioActualizarCita servicioActualizarCita = new ServicioActualizarCita(repositorioCita);
        
        List<DtoParametro> fechasFestivasParams = new ArrayList<>();
        fechasFestivasParams.add(new DtoParametro(1L, EnumParametro.NAVIDAD, EnumTipoParametro.FESTIVO, LocalDate.now().toString(), Boolean.TRUE));
        
        BasePrueba.assertThrows(() -> servicioActualizarCita.ejecutar(cita, 5, fechasFestivasParams), ExcepcionDiaNoLaborable.class, "No se pueden agendar citas los domingos");
    }
    
    @Test
    public void validarPacienteSiendoUnFestivo() {
    	
        Cita cita = new CitaTestDataBuilder().conId(1L).build();
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        Mockito.when(repositorioCita.existeExcluyendoId(Mockito.anyLong(), Mockito.any(), Mockito.anyLong(), Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioCita.existe(Mockito.any(), Mockito.anyLong(), Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioCita.contarCitasPorDia(Mockito.any())).thenReturn(1);
        ServicioActualizarCita servicioActualizarCita = new ServicioActualizarCita(repositorioCita);
        
        List<DtoParametro> fechasFestivasParams = new ArrayList<>();
        fechasFestivasParams.add(new DtoParametro(1L, EnumParametro.NAVIDAD, EnumTipoParametro.FESTIVO, LocalDate.now().toString(), Boolean.TRUE));
        
        BasePrueba.assertThrows(() -> servicioActualizarCita.ejecutar(cita, 5, fechasFestivasParams), ExcepcionDiaNoLaborable.class, "No se pueden agendar citas los dias festivos");
    }
  
}
