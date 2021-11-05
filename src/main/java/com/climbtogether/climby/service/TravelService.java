package com.climbtogether.climby.service;

import com.climbtogether.climby.dto.TravelDTO;

public interface TravelService {

	TravelDTO resgisterTravel(TravelDTO createTravelDTO);
	
	TravelDTO modifyTravel(TravelDTO modifyTravelDTO);
	
	TravelDTO getTravelById(String id);
	
	void removeTravel(String id);
	
	

}