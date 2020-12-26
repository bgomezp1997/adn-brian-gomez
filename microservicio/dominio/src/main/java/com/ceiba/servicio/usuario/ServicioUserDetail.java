package com.ceiba.servicio.usuario;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.ceiba.dominio.excepcion.ExcepcionAutenticacion;
import com.ceiba.modelo.dto.DtoUsuario;
import com.ceiba.puerto.dao.DaoUsuario;

public class ServicioUserDetail implements UserDetailsService {

	public static final String MENSAJE_ERROR_AUTENTICACION = "Hubo un error en la autenticacion del usuario. Usuario o contrase\u00f1a incorrectos.";

	private final DaoUsuario daoUsuario;

	public ServicioUserDetail(DaoUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		DtoUsuario dtoUsuario = null;
		try {
			dtoUsuario = daoUsuario.obtenerPorUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExcepcionAutenticacion(MENSAJE_ERROR_AUTENTICACION);
		}
		return new User(dtoUsuario.getUsername(), dtoUsuario.getPassword(), true, true, true, true, new ArrayList<>());
	}

}
