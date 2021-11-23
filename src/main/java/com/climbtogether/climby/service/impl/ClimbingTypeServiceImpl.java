package com.climbtogether.climby.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.climbtogether.climby.domain.ClimbingType;
import com.climbtogether.climby.dto.ClimbingTypeDTO;
import com.climbtogether.climby.mapper.ClimbingTypeMapper;
import com.climbtogether.climby.mapper.SchoolMapper;
import com.climbtogether.climby.repository.ClimbingTypeRepository;
import com.climbtogether.climby.service.ClimbingTypeService;

@Service
public class ClimbingTypeServiceImpl implements ClimbingTypeService{

	@Autowired
	private ClimbingTypeRepository climbingTypeRepository;

	@Autowired
	private ClimbingTypeMapper climbingTypeMapper;


	@Override
	public List<ClimbingTypeDTO> getClimbingTypeFindAll() {
		List<ClimbingType> climbingType = climbingTypeRepository.findAll();

		return climbingTypeMapper.listClimbingTypeToListClimbingTypeDTO(climbingType);
	}
}