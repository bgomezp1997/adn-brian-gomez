package com.ceiba.adaptador.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.modelo.dto.DtoEps;

public class MapeoEps implements RowMapper<DtoEps>, MapperResult {

    @Override
    public DtoEps mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String nit = resultSet.getString("nit");
        String telefono = resultSet.getString("telefono");
        String email = resultSet.getString("email");
        
        return new DtoEps(id, nombre, nit, telefono, email);
    }

}
