package com.climbtogether.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.climbtogether.app.dao.EscuelaRepository;
import com.climbtogether.app.entity.Escuela;

@Service
public class EscuelaService {

	@Autowired
	private EscuelaRepository escuelaRepository;
	
	// Metodo que muestra todos los viajes:
	public List<Escuela> findAll() {
		return escuelaRepository.sellAll();
	}
	
	public Optional<Escuela> findByNombre(String escuela) {
		return escuelaRepository.findByNombre(escuela);
	}
	
	public Escuela save(String nombre) {
		return escuelaRepository.save(new Escuela(0, nombre));
	}
	
	
}
