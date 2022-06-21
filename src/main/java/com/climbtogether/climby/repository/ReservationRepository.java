package com.climbtogether.climby.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.climbtogether.climby.domain.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	
	boolean existsById(Integer id);
	
	@Query(value="select *  from tb_reservation tr inner join tb_travel tt on tr.id_travel = tt.id_travel where tt.departure_date<now() and tr.reservation_status = true and tr.id_user = :id ",nativeQuery = true)
	List<Reservation> getByIdUser(Integer id);

	@Query(value="select *  from tb_reservation tr where tr.id_user = :id ",nativeQuery = true)
	List<Reservation> findByIdUser(Integer  id);
}


