package com.climbtogether.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.climbtogether.app.entity.Escuela;

public interface EscuelaRepository extends JpaRepository<Escuela, Integer>{

	//Metodo para consultar los viajes de ese dia:
		@Query(value = "SELECT * FROM escuelas ORDER BY id", nativeQuery = true)
		List<Escuela> sellAll();
	
	//Metodo encargado de buscar clientes por email
		Optional<Escuela> findByNombre(String nombre);
}
	