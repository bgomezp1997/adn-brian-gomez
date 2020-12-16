package com.ceiba.adaptador.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.modelo.dto.DtoParametro;
import com.ceiba.modelo.util.EnumParametro;

public class MapeoParametro implements RowMapper<DtoParametro>, MapperResult {

    @Override
    public DtoParametro mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        EnumParametro nombre = EnumParametro.valueOf(resultSet.getString("nombre"));
        String valor = resultSet.getString("valor");
        Boolean estado = resultSet.getBoolean("estado");

        return new DtoParametro(id, nombre, valor, estado);
    }

}
