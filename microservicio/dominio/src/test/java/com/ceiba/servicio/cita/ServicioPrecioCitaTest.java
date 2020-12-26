package com.ceiba.servicio.cita;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.ceiba.modelo.util.EnumParametro;
import com.ceiba.servicio.util.EnumEstratos;
import com.ceiba.util.premock.MockCache;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class ServicioPrecioCitaTest {

    @Test
    public void validarPrecioCitaEstratoBajo() throws JsonParseException, JsonMappingException, IOException  {
    	MockCache.mockParametros(Boolean.TRUE);
    	
    	String estratoBajo = EnumEstratos.ESTRATO_DOS.getValue().toString();
    	String especialidad = EnumParametro.RETINOLOGO.toString();
    	ServicioPrecioCita servicioPrecioCita = new ServicioPrecioCita();
    	Double precioCita = servicioPrecioCita.ejecutar(estratoBajo, especialidad);
        
        assertNotNull(precioCita);
        assertEquals(Double.valueOf(97500), precioCita);
    }
    
    @Test
    public void validarPrecioCitaEstratoMedio() throws JsonParseException, JsonMappingException, IOException  {
    	MockCache.mockParametros(Boolean.TRUE);
    	
    	String estratoMedio = EnumEstratos.ESTRATO_TRES.getValue().toString();
    	String especialidad = EnumParametro.RETINOLOGO.toString();
    	ServicioPrecioCita servicioPrecioCita = new ServicioPrecioCita();
    	Double precioCita = servicioPrecioCita.ejecutar(estratoMedio, especialidad);
        
        assertNotNull(precioCita);
        assertEquals(Double.valueOf(120000), precioCita);
    }
    
    @Test
    public void validarPrecioCitaEstratoAlto() throws JsonParseException, JsonMappingException, IOException  {
    	MockCache.mockParametros(Boolean.TRUE);
    	
    	String estratoAlto = EnumEstratos.ESTRATO_CINCO.getValue().toString();
    	String especialidad = EnumParametro.RETINOLOGO.toString();
    	ServicioPrecioCita servicioPrecioCita = new ServicioPrecioCita();
    	Double precioCita = servicioPrecioCita.ejecutar(estratoAlto, especialidad);
        
        assertNotNull(precioCita);
        assertEquals(Double.valueOf(135000), precioCita);
    }
    
    @Test
    public void validarPrecioCitaSinEstrato() throws JsonParseException, JsonMappingException, IOException  {
    	MockCache.mockParametros(Boolean.TRUE);
    	
    	String estrato = null;
    	String especialidad = EnumParametro.RETINOLOGO.toString();
    	ServicioPrecioCita servicioPrecioCita = new ServicioPrecioCita();
    	Double precioCita = servicioPrecioCita.ejecutar(estrato, especialidad);
        
        assertNotNull(precioCita);
        assertEquals(Double.valueOf(150000), precioCita);
    }
}
