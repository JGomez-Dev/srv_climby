package com.climbtogether.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.climbtogether.app.entity.Provincia;

public interface ProvinciaRepository  extends JpaRepository<Provincia, Integer>{

	//Metodo para consultar los viajes de ese dia:
		@Query(value = "SELECT * FROM provincias ORDER BY id", nativeQuery = true)
		List<Provincia> sellAll();
	
	//Metodo encargado de buscar clientes por email
		Optional<Provincia> findByNombre(String nombre);
	
}
