package com.climbtogether.climby.service;

import com.climbtogether.climby.dto.ProvinceDTO;
import com.climbtogether.climby.exceptions.ProvinceExistsConflicExcepcion;
import com.climbtogether.climby.exceptions.ProvinceNotFoundException;


public interface ProvinceService {


	ProvinceDTO getProvinceById(String id) throws ProvinceNotFoundException;
	
	ProvinceDTO resgisterProvince(ProvinceDTO createprovinceDTO) throws ProvinceExistsConflicExcepcion;
	
	ProvinceDTO modifyProvince(ProvinceDTO modifyProvinceDTO) throws ProvinceNotFoundException;
	
	void removeProvince(String id) throws ProvinceNotFoundException;
	
	

}
