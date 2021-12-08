package com.climbtogether.climby.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.climbtogether.climby.domain.Province;
import com.climbtogether.climby.domain.School;
import com.climbtogether.climby.dto.ProvinceDTO;
import com.climbtogether.climby.dto.SchoolDTO;

@Mapper(componentModel = "spring")
public interface SchoolMapper {
	
	School schoolDTOToSchool(SchoolDTO schoolDTO);
	
	SchoolDTO schoolToSchoolDTO(School school);
	
	List<SchoolDTO> listSchoolToListSchoolDTO(List<School> school);

}
