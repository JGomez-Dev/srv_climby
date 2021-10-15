package com.climbtogether.climby.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.climbtogether.climby.domain.Province;
import com.climbtogether.climby.dto.ConsultationProvinceResponseDTO;
import com.climbtogether.climby.dto.CreateProvinceDTO;
import com.climbtogether.climby.dto.ModifiedProvinceDTO;
import com.climbtogether.climby.dto.ProvinceDTO;
import com.climbtogether.climby.mapper.ProvinceMapper;
import com.climbtogether.climby.repository.ProvinceRepository;
import com.climbtogether.climby.service.ProvinceService;


@Service
public class ProvinceServiceImpl implements ProvinceService {
		
	private static final String MESSAGE_PROVINCE_NOT_FOUND = "Province id \"%s\" not found";
	private static final String MESSAGE_PROVINCE_ID_NULL = "Province id must not be null";
	
	@Autowired private ProvinceRepository provinceRepository;
	
	@Autowired
	private ProvinceMapper provinceMapper;
	
	@Override
	public ProvinceDTO resgisterProvince(CreateProvinceDTO createprovinceDTO) {
		
		Province province = provinceMapper.createProvinceDTOToProvince(createprovinceDTO);
		
		Province AttachedProvince =provinceRepository.save(province);
		
		return provinceMapper.provinceToprovinceDTO(AttachedProvince);
		
	}

	@Override
	public ConsultationProvinceResponseDTO getProvinceById(String id) {
		
		Optional<Province> province = provinceRepository.findById(id.toString());

		return provinceMapper.provinceToConsultationProvinceResponseDTO(province.get());
	}

	@Override
	public ProvinceDTO modifyProvince(ModifiedProvinceDTO modifyProvinceDTO) {
		
		Province province = provinceMapper.modifiedProvinceDTOToProvince(modifyProvinceDTO);
		String id = province.getId();
		Assert.notNull(id,MESSAGE_PROVINCE_ID_NULL);
		if(!provinceRepository.existsById(id)) {
			//Hay que meter una excepcion
			return null;
		}
		
		Province attachedProvince = provinceRepository.save(province);
		
		return provinceMapper.provinceToprovinceDTO(attachedProvince);
	}

	@Override
	public void removeProvince(String id) {
		Assert.notNull(id,MESSAGE_PROVINCE_ID_NULL);
		Optional<Province> attachedProvince = provinceRepository.findById(id);
		if(attachedProvince.isEmpty()) {
			//Excepcion
		}
		provinceRepository.deleteById(id);
		
		
		
		
	}

}
