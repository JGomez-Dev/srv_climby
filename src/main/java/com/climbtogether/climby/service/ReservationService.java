package com.climbtogether.climby.service;




import org.springframework.stereotype.Service;

import com.climbtogether.climby.dto.ReservationDTO;

@Service
public interface ReservationService {

	ReservationDTO resgisterReservation(ReservationDTO createReservationDTO);
	
	ReservationDTO modifyReservation(ReservationDTO modifyReservationDTO);
	
	ReservationDTO getReservationById(String id);
	
	void removeReservation(String id);
}
