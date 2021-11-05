package com.climbtogether.climby.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.climbtogether.climby.domain.Travel;
import com.climbtogether.climby.dto.TravelDTO;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TravelMapper {
	
	
	
	@Mapping(target ="driver.id",source= "userDTO")
	@Mapping(target ="province.id",source= "provinceDTO")
	Travel travelDTOToTravel(TravelDTO travelDTO);
	
	@Mapping(source ="driver.id",target= "userDTO")
	@Mapping(source ="province.id",target= "provinceDTO")
	TravelDTO  travelToTravelDTO(Travel  travel);
		

}
