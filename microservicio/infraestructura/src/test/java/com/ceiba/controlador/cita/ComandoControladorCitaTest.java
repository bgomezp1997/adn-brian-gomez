package com.ceiba.controlador.cita;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.ApplicationMock;
import com.ceiba.comando.ComandoCita;
import com.ceiba.comando.ComandoPrecio;
import com.ceiba.servicio.testdatabuilder.ComandoCitaTestDataBuilder;
import com.ceiba.servicio.testdatabuilder.ComandoPrecioTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(ComandoControladorCita.class)
public class ComandoControladorCitaTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception{
        ComandoCita comandoCita = new ComandoCitaTestDataBuilder().build();

        mocMvc.perform(post("/cita")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoCita)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    public void actualizar() throws Exception{
        Long id = 2L;
        ComandoCita comandoCita = new ComandoCitaTestDataBuilder().build();

        mocMvc.perform(put("/cita/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoCita)))
                .andExpect(status().isOk());
    }

    @Test
    public void eliminar() throws Exception {
        Long id = 2L;

        mocMvc.perform(delete("/cita/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    public void precioSinEstrato() throws Exception {
    	ComandoPrecio comandoPrecio = new ComandoPrecioTestDataBuilder().build();

        mocMvc.perform(post("/cita/precio")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoPrecio)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 150000.0}"));;
    }
    
    @Test
    public void precioConEstratoBajo() throws Exception {
    	ComandoPrecio comandoPrecio = new ComandoPrecioTestDataBuilder().conEstratoBajo().build();

        mocMvc.perform(post("/cita/precio")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoPrecio)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 97500.0}"));;
    }
    
    @Test
    public void precioConEstratoMedio() throws Exception {
    	ComandoPrecio comandoPrecio = new ComandoPrecioTestDataBuilder().conEstratoMedio().build();

        mocMvc.perform(post("/cita/precio")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoPrecio)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 120000.0}"));;
    }
    
    @Test
    public void precioConEstratoAlto() throws Exception {
    	ComandoPrecio comandoPrecio = new ComandoPrecioTestDataBuilder().conEstratoAlto().build();

        mocMvc.perform(post("/cita/precio")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoPrecio)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 135000.0}"));;
    }
}
