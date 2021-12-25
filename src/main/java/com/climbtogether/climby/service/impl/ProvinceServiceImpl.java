package com.climbtogether.climby.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.climbtogether.climby.domain.Province;
import com.climbtogether.climby.domain.Travel;
import com.climbtogether.climby.dto.ProvinceDTO;
import com.climbtogether.climby.mapper.ProvinceMapper;
import com.climbtogether.climby.repository.ProvinceRepository;
import com.climbtogether.climby.service.ProvinceService;


@Service
public class ProvinceServiceImpl implements ProvinceService {
		
	@Autowired private ProvinceRepository provinceRepository;
	
	@Autowired
	private ProvinceMapper provinceMapper;
	
	@Override
	public List<ProvinceDTO> getProvinceFindAll() {

		List<Province> province = provinceRepository.getProvincesWithTravels();
		
		province.add(0,new Province("Seleccione su provincia", 0));

		
		
		return provinceMapper.listProvinceToListProvinceDTO(province);
	}
	

}
