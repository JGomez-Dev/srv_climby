package com.climbtogether.climby.service;

import java.util.List;

import com.climbtogether.climby.dto.TravelDTO;

public interface TravelService {
	
	//Devuelve todos los viajes sin excepcion 
	List<TravelDTO> getTravelFindAll();
	
	//Devuelve todos los viajes de un usuario en concreto
	List<TravelDTO> getUsersTravels(Integer id);

	//Devuelve todos los viajes que tenga reservas realizadas por la persona que se pase por parametro
	List<TravelDTO> getTravelsWithUserReservation(Integer id);

	TravelDTO resgisterTravel(TravelDTO createTravelDTO);
	
	TravelDTO modifyTravel(TravelDTO modifyTravelDTO);
	
	void removeTravel(Integer id);
	
}