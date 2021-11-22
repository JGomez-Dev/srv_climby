package com.climbtogether.climby.service;

import com.climbtogether.climby.dto.SchoolDTO;

public interface SchoolService {


	SchoolDTO resgisterSchool(SchoolDTO createSchoolDTO);
	
	SchoolDTO getSchoolById(String name);
	
	
}
	