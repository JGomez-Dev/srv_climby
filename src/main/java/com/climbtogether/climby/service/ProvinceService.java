package com.climbtogether.climby.service;

import com.climbtogether.climby.dto.ConsultationProvinceResponseDTO;
import com.climbtogether.climby.dto.CreateProvinceDTO;
import com.climbtogether.climby.dto.ModifiedProvinceDTO;
import com.climbtogether.climby.dto.ProvinceDTO;


public interface ProvinceService {

	ProvinceDTO resgisterProvince(CreateProvinceDTO createprovinceDTO);
	
	ProvinceDTO modifyProvince(ModifiedProvinceDTO modifyProvinceDTO);
	
	ConsultationProvinceResponseDTO getProvinceById(String id);
	
	void removeProvince(String id);
	
	

}
