package com.climbtogether.climby.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.climbtogether.climby.domain.Reservation;
import com.climbtogether.climby.dto.ReservationDTO;
import com.climbtogether.climby.mapper.ReservationMapper;
import com.climbtogether.climby.repository.ReservationRepository;
import com.climbtogether.climby.service.ReservationService;


@Service
public class ReservationServiceImpl implements ReservationService {
	
	private static final String MESSAGE_RESERVATION_NOT_FOUND = "Reservation id \"%s\" not found";
	@Autowired private ReservationRepository reservationRepository;
	
	@Autowired
	private ReservationMapper reservationMapper;

	@Override
	public ReservationDTO resgisterReservation(ReservationDTO createReservationDTO){

		Reservation reservation = reservationMapper.reservationDTOToreservation(createReservationDTO);
		
		Reservation AttachedReservation =reservationRepository.save(reservation);
		
		return reservationMapper.reservationToReservationDTO(AttachedReservation);
		
	}

	@Override
	public ReservationDTO modifyReservation(ReservationDTO modifyReservationDTO) {
		Reservation reservation = reservationMapper.reservationDTOToreservation(modifyReservationDTO);
		Integer id = reservation.getId();
		if(!reservationRepository.existsById(id)) {
			
		}
		
		Reservation attachedReservation = reservationRepository.save(reservation);
		
		return reservationMapper.reservationToReservationDTO(attachedReservation);
	}



	@Override
	public void removeReservation(Integer id) {
		Optional<Reservation> attachedReservation = reservationRepository.findById(id);
	if(attachedReservation.isEmpty()) {
			
		}
	reservationRepository.deleteById(id);
			}

	@Override
	public ReservationDTO getReservationById(Integer id) {
	Optional<Reservation> reservation = reservationRepository.findById(id);
		if (reservation.isEmpty()) {
			
		}
		return reservationMapper.reservationToReservationDTO(reservation.get());
	}


}
