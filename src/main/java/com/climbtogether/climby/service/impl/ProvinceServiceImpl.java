package com.climbtogether.climby.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.climbtogether.climby.domain.Province;
import com.climbtogether.climby.dto.ProvinceDTO;
import com.climbtogether.climby.exceptions.ProvinceExistsConflicExcepcion;
import com.climbtogether.climby.exceptions.ProvinceNotFoundException;
import com.climbtogether.climby.mapper.ProvinceMapper;
import com.climbtogether.climby.repository.ProvinceRepository;
import com.climbtogether.climby.service.ProvinceService;


@Service
public class ProvinceServiceImpl implements ProvinceService {
		
	private static final String MESSAGE_PROVINCE_NOT_FOUND = "Province id \"%s\" not found";
	@Autowired private ProvinceRepository provinceRepository;
	
	@Autowired
	private ProvinceMapper provinceMapper;
	
	@Override
	public ProvinceDTO getProvinceById(String id) throws ProvinceNotFoundException {
		
		Optional<Province> province = provinceRepository.findById(id);
		
		if(province.isEmpty()) {
			throw new ProvinceNotFoundException(String.format(MESSAGE_PROVINCE_NOT_FOUND ,id));
		}
		
		return provinceMapper.provinceToprovinceDTO(province.get());
	}
	
	
	@Override
	@Transactional(rollbackFor = ProvinceExistsConflicExcepcion.class)
	public ProvinceDTO resgisterProvince(ProvinceDTO createprovinceDTO) throws ProvinceExistsConflicExcepcion {
		
		Province province = provinceMapper.provinceDTOToprovince(createprovinceDTO);
		
		if(provinceRepository.existsById(province.getId())) {
			throw new ProvinceExistsConflicExcepcion("Province id \""+province.getId()+"\" already exitst");
		}
		
		Province AttachedProvince =provinceRepository.save(province);
		
		return provinceMapper.provinceToprovinceDTO(AttachedProvince);
		
	}



	@Override
	@Transactional(rollbackFor = ProvinceNotFoundException.class)
	public ProvinceDTO modifyProvince(ProvinceDTO modifyProvinceDTO) throws ProvinceNotFoundException {
		
		Province province = provinceMapper.provinceDTOToprovince(modifyProvinceDTO);
		String id = province.getId();
		if(!provinceRepository.existsById(id)) {
			throw new ProvinceNotFoundException(String.format(MESSAGE_PROVINCE_NOT_FOUND ,id));
		}
		
		Province attachedProvince = provinceRepository.save(province);
		
		return provinceMapper.provinceToprovinceDTO(attachedProvince);
	}

	@Override
	@Transactional(rollbackFor = ProvinceNotFoundException.class)
	public void removeProvince(String id) throws ProvinceNotFoundException {
		Optional<Province> attachedProvince = provinceRepository.findById(id);
		if(attachedProvince.isEmpty()) {
			throw new ProvinceNotFoundException(String.format(MESSAGE_PROVINCE_NOT_FOUND ,id));
		}
		provinceRepository.deleteById(id);
		
		
		
		
	}

}
