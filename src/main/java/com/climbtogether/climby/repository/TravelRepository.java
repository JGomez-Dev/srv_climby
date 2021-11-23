package com.climbtogether.climby.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.climbtogether.climby.domain.Travel;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Integer> {
	
	
	@Query("select travel from Travel travel where driver.id_user != :id ")
	List<Travel> findAllTravels(@Param("id") Integer id);
	

}
