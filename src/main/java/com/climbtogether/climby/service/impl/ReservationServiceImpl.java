package com.climbtogether.climby.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.climbtogether.climby.domain.Reservation;
import com.climbtogether.climby.domain.User;
import com.climbtogether.climby.dto.ReservationDTO;
import com.climbtogether.climby.exceptions.ReservationNotFoundException;
import com.climbtogether.climby.exceptions.UserNotFoundException;
import com.climbtogether.climby.mapper.ReservationMapper;
import com.climbtogether.climby.repository.ReservationRepository;
import com.climbtogether.climby.service.ReservationService;


@Service
public class ReservationServiceImpl implements ReservationService {
	
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
	public ReservationDTO modifyReservation(ReservationDTO modifyReservationDTO) throws ReservationNotFoundException {
		Reservation reservation = reservationMapper.reservationDTOToreservation(modifyReservationDTO);
		Integer id = reservation.getId_reservation();
		if(!reservationRepository.existsById(id)) {
			throw new ReservationNotFoundException(String.format("Reserva no encontrado",id));
		}
		
		Reservation attachedReservation = reservationRepository.save(reservation);
		
		return reservationMapper.reservationToReservationDTO(attachedReservation);
	}



	@Override
	public void removeReservation(Integer id) throws ReservationNotFoundException {
		Optional<Reservation> attachedReservation = reservationRepository.findById(id);
		if (attachedReservation.isEmpty()) {
			throw new ReservationNotFoundException(String.format("Reserva no encontrado",id));
		}
		reservationRepository.deleteById(id);

	}

	@Override
	public ReservationDTO getReservationById(Integer id) throws ReservationNotFoundException {
	Optional<Reservation> reservation = reservationRepository.findById(id);
		if (reservation.isEmpty()) {
			throw new ReservationNotFoundException(String.format("Reserva no encontrado",id));
		}
		return reservationMapper.reservationToReservationDTO(reservation.get());
	}


}
