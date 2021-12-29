package com.climbtogether.climby.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.climbtogether.climby.domain.Province;
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
		
		List<Province> requestProvince = new ArrayList<>();;
		List<Province> provincesWithTravelsPrevious = provinceRepository.getProvincesWithTravelsprevious();
		List<Province> provincesWithTravelsLater = provinceRepository.getProvincesWithTravelsLater();
		List<Province> provincesWithTravels = provinceRepository.getProvincesWithTravels();
		 for (Province province1: provincesWithTravels) {
			if(province1.getNumberTravels()==0) {
				requestProvince.add(province1);
			}
		}
		 for (Province province2: provincesWithTravelsLater) {
			 requestProvince.add(province2);
		 }
		 
		 for (Province province3: provincesWithTravelsPrevious) {
			 province3.setNumberTravels(0);
			 requestProvince.add(province3);
		 }
		 ordenarArrayList(requestProvince);
		 
		 requestProvince.add(0,new Province("Seleccione su provincia", 0));
		
		return provinceMapper.listProvinceToListProvinceDTO(requestProvince);
	}
	private List<Province> ordenarArrayList(List<Province> requestProvince){
		Collections.sort(requestProvince, new Comparator<Province>() {
			@Override
			public int compare(Province p1, Province p2) {
				return new String(p1.getName()).compareTo(new String(p2.getName()));
			}
		});
		return requestProvince;
		
	}

}
