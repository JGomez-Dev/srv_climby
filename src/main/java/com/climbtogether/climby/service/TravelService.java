package com.climbtogether.climby.service;

import java.util.List;

import com.climbtogether.climby.dto.TravelDTO;
import com.climbtogether.climby.exceptions.TravelNotFoundException;
import com.climbtogether.climby.exceptions.UserNotFoundException;

public interface TravelService {
	
	//Devuelve todos los viajes sin excepcion 
	List<TravelDTO> getTravelFindAll();
	
	//Devuelve un viaje por ID
	TravelDTO getTravelById(Integer id) throws TravelNotFoundException;
	
	//Devuelve todos los viajes de un usuario en concreto
	List<TravelDTO> getUsersTravels(Integer id);

	//Devuelve todos los viajes que tenga reservas realizadas por la persona que se pase por parametro
	List<TravelDTO> getTravelsWithUserReservation(Integer id);

	TravelDTO resgisterTravel(TravelDTO createTravelDTO);
	
	TravelDTO modifyTravel(TravelDTO modifyTravelDTO) throws TravelNotFoundException;
	
	void removeTravel(Integer id)  throws TravelNotFoundException;
	
}