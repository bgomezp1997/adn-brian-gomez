package com.ceiba.comando.fabrica;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.ceiba.comando.ComandoUsuario;
import com.ceiba.modelo.entidad.Usuario;

@Component
public class FabricaUsuario {
	
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public FabricaUsuario(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	public Usuario crear(ComandoUsuario comandoUsuario) {
		return new Usuario(
				comandoUsuario.getId(), 
				comandoUsuario.getUsername(),
				bCryptPasswordEncoder.encode(comandoUsuario.getPassword())
		);
	}

}
