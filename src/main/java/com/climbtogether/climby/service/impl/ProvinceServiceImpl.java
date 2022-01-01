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

	@Autowired
	private ProvinceRepository provinceRepository;

	@Autowired
	private ProvinceMapper provinceMapper;

	@Override
	public List<ProvinceDTO> getProvinceFindAll() {
		List<Province> provincesWithTravelsLater = provinceRepository.getProvincesWithTravelsLater();
		List<Province> provinces = provinceRepository.findAll();

		for (Province province2 : provinces) {
			for (Province province3 : provincesWithTravelsLater) {
				if (province2.equals(province3)) {
					province2.setNumberTravels(province3.getNumberTravels());
				}
			}
		}
		ordenarArrayList(provinces);
		provinces.add(0, new Province("Seleccione su provincia", 0));

		return provinceMapper.listProvinceToListProvinceDTO(provinces);
	}

	private List<Province> ordenarArrayList(List<Province> requestProvince) {
		Collections.sort(requestProvince, new Comparator<Province>() {
			@Override
			public int compare(Province p1, Province p2) {
				return new String(p1.getName()).compareTo(new String(p2.getName()));
			}
		});
		return requestProvince;

	}

}
