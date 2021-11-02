package com.climbtogether.climby.service;

import com.climbtogether.climby.dto.ConsultationProvinceResponseDTO;
import com.climbtogether.climby.dto.CreateProvinceDTO;
import com.climbtogether.climby.dto.ModifiedProvinceDTO;
import com.climbtogether.climby.dto.ProvinceDTO;
import com.climbtogether.climby.exceptions.ProvinceExistsConflicExcepcion;
import com.climbtogether.climby.exceptions.ProvinceNotFoundException;


public interface ProvinceService {


	ConsultationProvinceResponseDTO getProvinceById(String id) throws ProvinceNotFoundException;
	
	ProvinceDTO resgisterProvince(CreateProvinceDTO createprovinceDTO) throws ProvinceExistsConflicExcepcion;
	
	ProvinceDTO modifyProvince(ModifiedProvinceDTO modifyProvinceDTO) throws ProvinceNotFoundException;
	
	void removeProvince(String id) throws ProvinceNotFoundException;
	
	

}
