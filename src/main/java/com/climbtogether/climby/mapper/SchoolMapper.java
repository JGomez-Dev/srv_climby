package com.climbtogether.climby.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.climbtogether.climby.domain.School;
import com.climbtogether.climby.dto.SchoolDTO;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SchoolMapper {
	
	School schoolDTOToSchool(SchoolDTO schoolDTO);
	
	SchoolDTO schoolToSchoolDTO(School school);
	

}
