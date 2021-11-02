package com.climbtogether.climby.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.climbtogether.climby.domain.School;
import com.climbtogether.climby.dto.SchoolDTO;
import com.climbtogether.climby.mapper.SchoolMapper;
import com.climbtogether.climby.repository.SchoolRepository;
import com.climbtogether.climby.service.SchoolService;

@Service
public class SchoolServiceImpl implements SchoolService {
		
	private static final String MESSAGE_SCHOOL_NOT_FOUND = "School id \"%s\" not found";
	private static final String MESSAGE_SCHOOL_ID_NULL = "School id must not be null";
	
	@Autowired private SchoolRepository schoolRepository;
	
	@Autowired
	private SchoolMapper schoolMapper;
	
	@Override
	public SchoolDTO resgisterSchool(SchoolDTO createSchoolDTO) {
		
		School school = schoolMapper.schoolDTOToSchool(createSchoolDTO);
		
		School AttachedSchool = schoolRepository.save(school);
		
		return schoolMapper.schoolToSchoolDTO(AttachedSchool);
		
	}

	@Override
	public SchoolDTO getSchoolById(String id) {
		
		Optional<School> school = schoolRepository.findById(id.toString());

		return schoolMapper.schoolToSchoolDTO(school.get());
	}

	@Override
	public SchoolDTO modifySchool(SchoolDTO modifySchoolDTO) {
		
		School school = schoolMapper.schoolDTOToSchool(modifySchoolDTO);
		String id = school.getId();
		Assert.notNull(id,MESSAGE_SCHOOL_ID_NULL);
		if(!schoolRepository.existsById(id.toString())) {
			//Hay que meter una excepcion
			return null;
		}
		
		School attachedSchool = schoolRepository.save(school);
		
		return schoolMapper.schoolToSchoolDTO(attachedSchool);
	}

	@Override
	public void removeSchool(String id) {
		Assert.notNull(id,MESSAGE_SCHOOL_ID_NULL);
		Optional<School> attachedSchool = schoolRepository.findById(id);
		if(attachedSchool.isEmpty()) {
			//Excepcion
		}
		schoolRepository.deleteById(id);
		
		
		
		
	}

}
