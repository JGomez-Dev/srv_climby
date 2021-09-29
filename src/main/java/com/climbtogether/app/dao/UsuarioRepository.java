package com.climbtogether.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.climbtogether.app.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	//Metodo para hacer el login, revisar
	@Query(value = "SELECT * FROM usuarios WHERE contrasena =  ?1 AND email = '?2'", nativeQuery = true)
	List<Usuario> loginUsuario(@Param("contrasena") String contrasena, @Param("email") String email );
	
	//Usuario findByEmail(String email);
	
	//Metodo encargado de buscar clientes por email
	Optional<Usuario> findByEmail(String email);
}