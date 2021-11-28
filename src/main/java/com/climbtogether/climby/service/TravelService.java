package com.climbtogether.climby.service;

import java.util.List;

import com.climbtogether.climby.dto.TravelDTO;

public interface TravelService {

	TravelDTO resgisterTravel(TravelDTO createTravelDTO);
	
	TravelDTO modifyTravel(TravelDTO modifyTravelDTO);
	
	void removeTravel(Integer id);

	TravelDTO getTravelById(Integer id);
	
	List<TravelDTO> getTravelFindAll(Integer id);
	
	List<TravelDTO> getTravelsWithUserReservation(Integer id);

}