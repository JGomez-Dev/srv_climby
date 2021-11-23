package com.climbtogether.climby.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.climbtogether.climby.domain.ClimbingType;
import com.climbtogether.climby.dto.ClimbingTypeDTO;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ClimbingTypeMapper {
	
	List<ClimbingTypeDTO> listClimbingTypeToListClimbingTypeDTO(List<ClimbingType> ClimbingType);

}