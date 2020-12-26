package com.ceiba.controlador.trm;

import java.time.LocalDate;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.infraestructura.superintendencia.TcrmResponse;
import com.ceiba.infraestructura.superintendencia.TcrmServicesInterface;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/trm")
@Api(tags={"Controlador consulta TRM"})
public class ConsultaControladorTRM {
	
	private static final String URL_TMR = "https://www.superfinanciera.gov.co/SuperfinancieraWebServiceTRM/TCRMServicesWebService/TCRMServicesWebService";
    
    @GetMapping
    @ApiOperation("Obtener TRM")
    public TcrmResponse obtener() {
    	
    	JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
    	jaxWsProxyFactoryBean.setAddress(URL_TMR);
		TcrmServicesInterface tcrmServicesInterface = jaxWsProxyFactoryBean.create(TcrmServicesInterface.class);

    	return tcrmServicesInterface.queryTCRM(LocalDate.now().toString());
    }

}