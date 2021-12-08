package com.climbtogether.climby.service;

import java.util.List;

import com.climbtogether.climby.dto.SchoolDTO;

public interface SchoolService {

	SchoolDTO resgisterSchool(SchoolDTO createSchoolDTO);
	
//	SchoolDTO getSchoolById(String name);
	
	List<SchoolDTO> getSchoolFindAll();

}
	