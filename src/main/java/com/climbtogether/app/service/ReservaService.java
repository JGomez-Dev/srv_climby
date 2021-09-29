package com.climbtogether.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.climbtogether.app.entity.*;
import com.climbtogether.app.dao.*;

@Service
public class ReservaService {
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	
	// Metodo que muestra viaje por id:
	public Optional<List<Reserva>> findByIdList(Integer id) {
		return reservaRepository.findByIdList(id);
	}
	
	// Metodo que muestra viaje por id:
	public Optional<Reserva> findById(Integer id) {
		return reservaRepository.findById(id);
	}
	
	// Metodo que muestra viaje por id:
	public void updateReserva(Reserva id) {
		id.setEstadoReserva((byte)2);
		reservaRepository.save(id);
	}
	
	
	// Metodo que muestra todos los viajes:
	public List<Reserva> findAll() {
		return reservaRepository.findAll();
	}
		
	// Metodo para eliminar un Viaje:
	public Reserva delete(Reserva reserva) {
		reservaRepository.delete(reserva);
		return null;
	}
	
	// Metodo para eliminar un Viaje por id:
	public Reserva deleteById(Integer idViaje, Integer idPasajero) {
		reservaRepository.deleteByIds(idViaje,idPasajero);
		return null;
	}
	
	// Metodo para actualizar viaje por id (Num plazas)
	public Reserva save(Reserva reserva) {
		return reservaRepository.save(reserva);
	}

	// Metodo que muestra una reserva por idusuario e idviaje:
	public Optional <Reserva> muestraReservaPorIdUsuarioYidViaje(Integer idUsuario, Integer idViaje) {
		return reservaRepository.findByIdUsuarioYidViaje(idUsuario,idViaje);
	}
	
	// Metodo que muestra las reservas por idusuario:
	public Optional <List<Reserva>> muestraReservasPorIdUsuario(Integer idUsuario) {
		return reservaRepository.obtenerReservasUsuarioByIdUsuario(idUsuario);
	}
	
	// Metodo que muestra las reservas por idviaje:
	public Optional <List<Reserva>> muestraReservasPorIdViaje(Integer idViaje) {
		return reservaRepository.obtenerReservasUsuarioByIdViaje(idViaje);
	}
	
	// Metodo utilizado para eliminar una reserva por idUsuario e idViaje:
	public Integer eliminarReservaIdViajeIdPasajero(Integer idViaje, Integer idPasajero) {
		return reservaRepository.eliminarReservaIdViajeIdPasajero(idViaje,idPasajero);
	}
}