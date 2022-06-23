package com.climbtogether.climby.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.climbtogether.climby.controller.MessageController;
import com.climbtogether.climby.controller.UserController;
import com.climbtogether.climby.domain.Message;
import com.climbtogether.climby.domain.Reservation;
import com.climbtogether.climby.domain.Travel;
import com.climbtogether.climby.dto.MessageDTO;
import com.climbtogether.climby.dto.ReservationDTO;
import com.climbtogether.climby.exceptions.ReservationNotFoundException;
import com.climbtogether.climby.mapper.MessageMapper;
import com.climbtogether.climby.mapper.ReservationMapper;
import com.climbtogether.climby.repository.ReservationRepository;
import com.climbtogether.climby.repository.TravelRepository;
import com.climbtogether.climby.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private TravelRepository travelRepository;

	@Autowired
	private ReservationMapper reservationMapper;

	@Autowired
	private MessageController messageController;

	@Autowired
	private MessageMapper messageMapper;

	@Autowired
	UserController userController;

	@Override
	public ReservationDTO resgisterReservation(
			ReservationDTO createReservationDTO) {

		Reservation reservation = reservationMapper
				.reservationDTOToreservation(createReservationDTO);

		Reservation AttachedReservation = reservationRepository
				.save(reservation);

		return reservationMapper
				.reservationToReservationDTO(AttachedReservation);

	}

	@Override
	public ReservationDTO modifyReservation(ReservationDTO modifyReservationDTO)
			throws ReservationNotFoundException {
		Reservation reservation = reservationMapper
				.reservationDTOToreservation(modifyReservationDTO);
		Integer id = reservation.getId_reservation();
		if (!reservationRepository.existsById(id)) {
			throw new ReservationNotFoundException(
					String.format("Reserva no encontrado", id));
		}
		if (modifyReservationDTO.getMessageDTO() != null) {
			MessageDTO messageDTO = messageController
					.registerMessage(modifyReservationDTO.getMessageDTO());
			Message message = messageMapper.messageDTOToMessage(messageDTO);
			reservation.setMessage(message);
		}
		Reservation attachedReservation = reservationRepository
				.save(reservation);
		return reservationMapper
				.reservationToReservationDTO(attachedReservation);
	}

	@Override
	public void removeReservation(Integer id)
			throws ReservationNotFoundException {
		Optional<Reservation> attachedReservation = reservationRepository
				.findById(id);
		if (attachedReservation.isEmpty()) {
			throw new ReservationNotFoundException(
					String.format("Reserva no encontrado", id));
		}
		reservationRepository.deleteById(id);

	}

	@Override
	public ReservationDTO getReservationById(Integer id)
			throws ReservationNotFoundException {
		Optional<Reservation> reservation = reservationRepository.findById(id);
		if (reservation.isEmpty()) {
			throw new ReservationNotFoundException(
					String.format("Reserva no encontrado", id));
		}
		return reservationMapper.reservationToReservationDTO(reservation.get());
	}

	public Integer unreadMessages(Integer id)
			throws ReservationNotFoundException {
		int numNotifications = 0;
		boolean existsReservation = false;
		List<Travel> travels = travelRepository.getUsersTravels(id);

		for (Travel travel : travels) {
			if (travel.getReservation().size() != 0) {
				existsReservation = true;
			}
			if (existsReservation == true) {
				for (Reservation reservation : travel.getReservation()) {
					if (reservation.getValuationStatus() != null) {
						if (reservation.getValuationStatus() == false) {
							numNotifications++;
						}
					}

					if (reservation.getMessage() != null) {
						if (reservation.getMessage().getRead() == false) {
							numNotifications++;
						}
					}
				}
			}
			existsReservation = false;
		}

		return numNotifications;
	}
}
