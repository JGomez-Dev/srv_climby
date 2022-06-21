package com.climbtogether.climby.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.climbtogether.climby.domain.Travel;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Integer> {
	
	@Query("select travel from Travel travel where driver.id_user = :id ")
	List<Travel> getUsersTravels(@Param("id") Integer id);
	
	@Query(value="select tp.name_province, count(tt.province) as number_travels from tb_province tp  left join tb_travel tt on tp.name_province = tt.province where tt.departure_date >= CURRENT_DATE group by tp.name_province order by tp.name_province",nativeQuery = true)
	List<Travel> getTravelsWithUserReservation(@Param("id") Integer id);
	

}
