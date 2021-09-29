package com.climbtogether.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.climbtogether.app.entity.Escuela;
import com.climbtogether.app.service.EscuelaService;

@RestController
@RequestMapping("/api/escuelas")
@CrossOrigin
public class EscuelaController {

	@Autowired
	private EscuelaService escuelaService;
	
	//Consulta todas las reservas
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<?>> findAll() {
		List<Escuela> vOpt = escuelaService.findAll();
		if (vOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(vOpt);
	}
	
	// Crea un viaje
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody String nombre) {
		Optional<Escuela> vOpt = escuelaService.findByNombre(nombre.substring(1, nombre.length()-1));
		if (!vOpt.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(escuelaService.save(nombre.substring(1, nombre.length()-1)));
		}
		return ResponseEntity.status(500).build();

	}
	
}
