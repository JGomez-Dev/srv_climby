package com.climbtogether.climby.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.climbtogether.climby.domain.Travel;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Integer> {
	
	//TODO Tienen que ser viajes de 2 meses hacia atras reutilizar este para Proximas salidas y hacer el Mis Salidas.
	@Query("select travel from Travel travel where driver.id_user = :id and date(departure_date)=date(now())")
	List<Travel> getUsersTravels(@Param("id") Integer id);
	
	@Query("select travel from Travel travel left join travel.reservation reservation on travel.id_travel=reservation.travel.id_travel where (reservation.passenger.id_user = :id or travel.driver.id_user = :id) and (departure_date>now() or date(departure_date)=date(now()))")
	List<Travel> getTravelsWithUserReservation(@Param("id") Integer id);
	

}
