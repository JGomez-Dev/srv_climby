package com.climbtogether.app.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.climbtogether.app.entity.*;
import com.climbtogether.app.dao.*;


@Service
public class UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	// Metodo utilizado para registrar un nuevo usuario.
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	//Metodo para consultar filtrando por email
	public Optional<Usuario> findByEmail(String email){
		return usuarioRepository.findByEmail(email);
	}
		
	//Metodo para consultar filtrando por id
	public Optional<Usuario> findById(Integer id){
		return usuarioRepository.findById(id);
	}
	
	public Usuario delete(Usuario usuario) {
		usuarioRepository.delete(usuario);
		return null;
	}
	
}