package com.climbtogether.climby.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.climbtogether.climby.domain.Province;
import com.climbtogether.climby.domain.Travel;
import com.climbtogether.climby.dto.ProvinceDTO;
import com.climbtogether.climby.dto.TravelDTO;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProvinceMapper {
	
	@Mapping(source = "id", target="id_province")
	Province provinceDTOToprovince(ProvinceDTO provinceDTO);
	
	@Mapping(target="id",source = "id_province")
	ProvinceDTO provinceToprovinceDTO(Province province);

	List<ProvinceDTO> listProvinceToListProvinceDTO(List<Province> travel);
		

}
