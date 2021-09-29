package com.climbtogether.app.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.climbtogether.app.entity.*;

public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
	
	//Metodo para obtener la reserva por idreserva:
	@Query(value = "SELECT * FROM reservas WHERE idreserva = ?1", nativeQuery = true)
	Optional<List<Reserva>> findByIdList(@Param("idreserva") Integer idReserva );
	
	//Metodo para obtener la reserva por idusuario e idviaje:
	@Query(value = "SELECT * FROM reservas WHERE idusuariopasajero=?1 AND idviaje=?2 LIMIT 1", nativeQuery = true)
	Optional <Reserva> findByIdUsuarioYidViaje(@Param("idusuariopasajero") Integer idUsuario, @Param("idviaje") Integer idViaje);
	
	//Metodo para obtener las reservas por idusuario:
	@Query(value = "SELECT * FROM reservas WHERE id_pasajero=?1 ORDER BY idreserva DESC", nativeQuery = true)
	Optional <List<Reserva>> obtenerReservasUsuarioByIdUsuario(@Param("idusuariopasajero") Integer idUsuario);
	
	//Metodo para obtener las reservas por idviaje:
	@Query(value = "SELECT * FROM reservas WHERE idviaje=?1 AND estado_reserva <> 3", nativeQuery = true)
	Optional <List<Reserva>> obtenerReservasUsuarioByIdViaje(@Param("idviaje") Integer idviaje);
	
	//Metodo para eliminar reserva por idviaje, e idusuario:
	@Modifying @Transactional @Query(value = "DELETE FROM reserva WHERE idviaje=?1 AND idusuariopasajero=?2", nativeQuery = true)
	Integer eliminarReservaIdViajeIdPasajero(@Param("idviaje") Integer idviaje, @Param("idusuariopasajero") Integer idusuariopasajero);
	
	//Metodo para eliminar reserva por idviaje, e idusuario:
	
	@Modifying @Transactional @Query(value = "UPDATE reservas SET estado_reserva ='2' WHERE id_pasajero=?2 AND idviaje=?1", nativeQuery = true)
	void updateReserva(@Param("idviaje") Integer idviaje, @Param("idusuariopasajero") Integer idusuariopasajero);

	@Modifying @Transactional @Query(value = "DELETE FROM reservas WHERE idviaje=?1 AND id_pasajero=?2", nativeQuery = true)
	void deleteByIds(@Param("idviaje") int idviaje, @Param("idusuariopasajero") int idusuariopasajero);

}