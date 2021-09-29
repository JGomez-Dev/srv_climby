package com.climbtogether.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.climbtogether.app.entity.Usuario;
import com.climbtogether.app.service.UsuarioService;
@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	// Lee un reserva por id de viaje
	@RequestMapping(value = "getUserByEmail/{email}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Usuario>> findByViajeId(@PathVariable("email") String email) {
		Optional<Usuario> reOptional = usuarioService.findByEmail(email);
		if (reOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(reOptional);
	}
	
	// Crea un viaje
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Usuario usuario) {
		Optional<Usuario> vOpt = usuarioService.findByEmail(usuario.getEmail());
		if (!vOpt.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
		}
		return ResponseEntity.status(500).build();

	}
	
	// Actualiza un usuario
	@RequestMapping(value = "update/{email}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable("email") String email, @RequestBody Usuario usuarioDetails) {
		Optional<Usuario> vOpt = usuarioService.findByEmail(email);
		if (!vOpt.isPresent()) {
			return ResponseEntity.notFound().build();

		} else {
			
			vOpt.get().setEmail(usuarioDetails.getEmail());
			vOpt.get().setEsconductor(usuarioDetails.getEsconductor());
			vOpt.get().setEspasajero(usuarioDetails.getEspasajero());
			vOpt.get().setExperiencia(usuarioDetails.getExperiencia());
			vOpt.get().setFotousuario(usuarioDetails.getFotousuario());			
			vOpt.get().setIdusuario(usuarioDetails.getIdusuario());
			vOpt.get().setNombreCompleto(usuarioDetails.getNombreCompleto());
			vOpt.get().setPuntuacion(usuarioDetails.getPuntuacion());
			vOpt.get().setReservas(usuarioDetails.getReservas());
			vOpt.get().setSalidas(usuarioDetails.getSalidas());
			vOpt.get().setTelefono(usuarioDetails.getTelefono());
			vOpt.get().setViajes(usuarioDetails.getViajes());
			
			return new ResponseEntity<>(usuarioService.save(usuarioDetails), HttpStatus.OK);
		}

	}
	
}
