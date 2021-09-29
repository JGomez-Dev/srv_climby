package com.climbtogether.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.climbtogether.app.dao.ProvinciaRepository;
import com.climbtogether.app.entity.Provincia;

@Service
public class ProvinciaService {
	
	@Autowired
	private ProvinciaRepository provinciaRepository;
	
	// Metodo que muestra todos los viajes:
	public List<Provincia> findAll() {
		return provinciaRepository.sellAll();
	}
	
	//Metodo para consultar filtrando por email
	public Optional<Provincia> getProvinciaByName(String nombre){
		return provinciaRepository.findByNombre(nombre);
	}
	

}
