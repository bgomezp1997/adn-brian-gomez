package com.ceiba.servicio.cita;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ceiba.cache.CacheUtil;
import com.ceiba.dominio.excepcion.ExcepcionCitasExcedidas;
import com.ceiba.dominio.excepcion.ExcepcionDiaNoLaborable;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.dto.DtoParametro;
import com.ceiba.modelo.entidad.Cita;
import com.ceiba.modelo.util.EnumParametro;
import com.ceiba.modelo.util.EnumTipoParametro;
import com.ceiba.puerto.repositorio.RepositorioCita;

public class ServicioCrearCita {
	
	private static final String LA_CITA_YA_EXISTE_EN_EL_SISTEMA = "La cita ya existe en el sistema";
	private static final String CUPO_DE_CITAS_POR_DIA_COMPLETO = "No se pueden hacer mas citas por el dia de hoy";
	private static final String EL_DIA_ESCOGIDO_ES_DOMINGO = "No se pueden agendar citas los domingos";
	private static final String EL_DIA_ESCOGIDO_ES_FESTIVO = "No se pueden agendar citas los dias festivos";

    private final RepositorioCita repositorioCita;

    public ServicioCrearCita(RepositorioCita repositorioCita) {
        this.repositorioCita = repositorioCita;
    }

    public Long ejecutar(Cita cita) {
        validarExistenciaPrevia(cita);
        validarTopeCitas(cita, Integer.parseInt(CacheUtil.obtainParameterByTipoParametroAndParametro(EnumTipoParametro.GENERAL, EnumParametro.CANTIDAD_CITAS_DIA)));
        validarFechas(cita, CacheUtil.obtainListByTipoParametro(EnumTipoParametro.FESTIVO));
        return this.repositorioCita.crear(cita);
    }

    private void validarExistenciaPrevia(Cita cita) {
        boolean existe = this.repositorioCita.existe(cita.getFechaCita(), cita.getIdPaciente(), cita.getIdMedico());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_CITA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
    
    private void validarTopeCitas(Cita cita, Integer cantidadCitasPermitidas) {
        Integer cantidadCitasGuardadas = this.repositorioCita.contarCitasPorDia(cita.getFechaCita());
        if(cantidadCitasGuardadas >= cantidadCitasPermitidas) {
            throw new ExcepcionCitasExcedidas(CUPO_DE_CITAS_POR_DIA_COMPLETO);
        }
    }
    
    private void validarFechas(Cita cita, List<DtoParametro> fechasFestivasParams) {
    	if(!fechasFestivasParams.isEmpty()) {
    		Calendar fechaCitaCalendar = Calendar.getInstance();
        	final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        	fechaCitaCalendar.setTime(Date.from(cita.getFechaCita().toLocalDate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        	if(fechaCitaCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
    			throw new ExcepcionDiaNoLaborable(EL_DIA_ESCOGIDO_ES_DOMINGO);
    		}
    		for (DtoParametro dtoParametro : fechasFestivasParams) {
    			if(cita.getFechaCita().toLocalDate().isEqual(LocalDate.parse(dtoParametro.getValor(), formatter))) {
    				throw new ExcepcionDiaNoLaborable(EL_DIA_ESCOGIDO_ES_FESTIVO);
    			}
    		}
    	}
    }

}
