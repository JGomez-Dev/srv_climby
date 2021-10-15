package com.climbtogether.climby.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.climbtogether.climby.domain.Province;
import com.climbtogether.climby.dto.ConsultationProvinceResponseDTO;
import com.climbtogether.climby.dto.CreateProvinceDTO;
import com.climbtogether.climby.dto.ModifiedProvinceDTO;
import com.climbtogether.climby.dto.ProvinceDTO;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProvinceMapper {
	
	@Mapping(source = "id", target="id")
	Province provinceDTOToprovince(ProvinceDTO provinceDTO);
	
	@Mapping(target="id",source = "id")
	ProvinceDTO provinceToprovinceDTO(Province province);
	
	@Mapping(source = "id", target="id")
	ConsultationProvinceResponseDTO provinceToConsultationProvinceResponseDTO (Province province);
	
	Province createProvinceDTOToProvince (CreateProvinceDTO createProvinceDTO);
	
	Province modifiedProvinceDTOToProvince(ModifiedProvinceDTO modifiedProvinceDTO);
	
		

}
