package com.climbtogether.climby.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.climbtogether.climby.domain.Province;
import com.climbtogether.climby.domain.Travel;

public class OrdenarArrayList {

	public static List<Travel> ordenarArrayListForDate(List<Travel> requestTravel) {
		Collections.sort(requestTravel, new Comparator<Travel>() {
			@Override
			 public int compare(Travel t1, Travel t2) {
	            return t1.getDepartureDate().compareTo(t2.getDepartureDate());
	        }
		});
		return requestTravel;

	}
	
	
	public static List<Province> ordenarArrayListForNameProvince(List<Province> requestProvince) {
		Collections.sort(requestProvince, new Comparator<Province>() {
			@Override
			public int compare(Province p1, Province p2) {
				return new String(p1.getName()).compareTo(new String(p2.getName()));
			}
		});
		return requestProvince;

	}
}
