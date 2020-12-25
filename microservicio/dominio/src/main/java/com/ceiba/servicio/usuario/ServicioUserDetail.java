package com.ceiba.servicio.usuario;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ceiba.modelo.dto.DtoUsuario;
import com.ceiba.puerto.dao.DaoUsuario;

public class ServicioUserDetail implements UserDetailsService {
	
	private final DaoUsuario daoUsuario;
	
	public ServicioUserDetail(DaoUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DtoUsuario dtoUsuario;
        dtoUsuario = daoUsuario.obtenerPorUsername(username);

        return new org.springframework.security.core.userdetails.User(username, dtoUsuario.getPassword(), true, true, true, true, new ArrayList<>());
	}

}
