package com.climbtogether.climby.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.climbtogether.climby.domain.Province;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Integer> {
	
	
//	@Query(value="select * from  tb_province tp",nativeQuery = true)
//	List<Province> findAll();
	
	@Query(value="select tp.name_province, count(tt.province) as number_travels from tb_province tp  left join tb_travel tt on tp.name_province = tt.province where tt.departure_date >= CURRENT_DATE group by tp.name_province order by tp.name_province",nativeQuery = true)
	List<Province> getProvincesWithTravelsLater();
	
//	@Query(value="select tp.name_province, count(tt.province) as number_travels from tb_province tp  left join tb_travel tt on tp.name_province = tt.province where tt.departure_date < CURRENT_DATE group by tp.name_province order by tp.name_province",nativeQuery = true)
//	List<Province> getProvincesWithTravelsprevious();
//	
//	
//	@Query(value="select tp.name_province, count(tt.province) as number_travels from tb_province tp left join tb_travel tt on tp.name_province = tt.province  group by tp.name_province order by tp.name_province",nativeQuery = true)
//	List<Province> getProvincesWithTravels();
}
