package com.climbtogether.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.climbtogether.app.entity.Provincia;
import com.climbtogether.app.service.ProvinciaService;

@RestController
@RequestMapping("/api/provincias")
@CrossOrigin
public class ProvinciaController {

	
	@Autowired
	private ProvinciaService provinciaService;
	
	//Consulta todas las provincias
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<?>> findAll() {
		List<Provincia> vOpt = provinciaService.findAll();
		if (vOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(vOpt);

	}
	
	// Lee una una provincia por nombre
	@RequestMapping(value = "getProvinciaByName/{nombre}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Provincia>> getProvinciaByName(@PathVariable("nombre") String nombre) {
		Optional<Provincia> reOptional = provinciaService.getProvinciaByName(nombre);
		if (reOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(reOptional);
	}
		
	
}
