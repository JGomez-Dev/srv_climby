package com.climbtogether.climby.service;

import com.climbtogether.climby.dto.ReservationDTO;

public interface ReservationService {

	ReservationDTO resgisterReservation(ReservationDTO createReservationDTO);
	
	ReservationDTO modifyReservation(ReservationDTO modifyReservationDTO);
	
	ReservationDTO getReservationById(Integer id);
	
	void removeReservation(Integer id);
}
