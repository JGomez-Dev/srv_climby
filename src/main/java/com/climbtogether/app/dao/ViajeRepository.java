package com.climbtogether.app.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.climbtogether.app.entity.*;

public interface ViajeRepository extends JpaRepository<Viaje, Integer> {

	// Metodo para consultar los viajes de ese dia:
	@Query(value = "SELECT * FROM viajes WHERE fechasalida >=  ?1 AND fechasalida <= ?2 AND precio <= ?3 AND numplazasdisponibles >=1 AND idusuarioconductor != ?4 ORDER BY fechasalida ASC", nativeQuery = true)
	List<Viaje> mostrarViajesDelDia(@Param("fechasalida") String fechaIni, @Param("fechasalida") String fechaFin,
			@Param("precio") BigDecimal precioMax, @Param("idusuarioconductor") int id);

	// Metodo para consultar los viajes publicados por un usuario:
	@Query(value = "SELECT * FROM viajes WHERE id_conductor = ?1 ORDER BY fechasalida ASC", nativeQuery = true)
	List<Viaje> mostrarViajesPublicados(@Param("id_conductor") Integer idusuarioconductor);

	// Metodo para consultar los viajes publicados por un usuario:
	@Query(value = "SELECT * FROM `viajes` v INNER JOIN reservas R ON V.idviaje = R.idviaje WHERE R.id_pasajero = ?1 ORDER BY fechareserva DESC LIMIT 1", nativeQuery = true)
	Viaje getLastTravel(@Param("id_pasajero") Integer id_pasajero);

	//Metodo para consultar los viajes publicados por un usuario:
//	@Query(value = "UPDATE viajes SET update viajes set id_conductor=?2, fechasalida=?3, fecha_salida_string=?4, lugar=?5, numplazasdisponibles=?6, provincia_id=?7, tipo=?8 where idviaje=?1", nativeQuery = true)
//	Optional <Viaje> update(@Param("idviaje") Integer idviaje, @Param("id_conductor") int id_conductor);

	@Query(value = "SELECT v.`idviaje`, v.`fechasalida`, v.`lugar`, v.`numplazasdisponibles`, v.`id_conductor`, v.`tipo`, v.`fecha_salida_string`, rs.id_pasajero, rs.idreserva, rs.estado_reserva, rs.estado_valoracion, rs.fechareserva, v.provincia_id "
			+ "FROM `viajes` v LEFT JOIN reservas rs on rs.idviaje = v.idviaje "
			+ "INNER JOIN `provincias` p on v.provincia_id = p.id " + "GROUP by v.idviaje "
			+ "ORDER by fechasalida", nativeQuery = true)
	List<Viaje> mostrarViajesConReservas();
}
