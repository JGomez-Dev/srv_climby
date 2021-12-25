package com.climbtogether.climby.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.climbtogether.climby.domain.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	
	boolean existsById(Integer id);

}
