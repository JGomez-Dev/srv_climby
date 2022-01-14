package com.climbtogether.climby.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.climbtogether.climby.domain.Message;
import com.climbtogether.climby.domain.Reservation;
import com.climbtogether.climby.domain.School;
import com.climbtogether.climby.dto.MessageDTO;
import com.climbtogether.climby.dto.ReservationDTO;
import com.climbtogether.climby.dto.SchoolDTO;
import com.climbtogether.climby.exceptions.ReservationNotFoundException;
import com.climbtogether.climby.mapper.MessageMapper;
import com.climbtogether.climby.mapper.ReservationMapper;
import com.climbtogether.climby.repository.MessageRepository;
import com.climbtogether.climby.repository.ReservationRepository;
import com.climbtogether.climby.service.MessageService;
import com.climbtogether.climby.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService, MessageService {

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private ReservationMapper reservationMapper;

	@Autowired
	private MessageMapper messageMapper;

	@Override
	public ReservationDTO resgisterReservation(ReservationDTO createReservationDTO) {

		Reservation reservation = reservationMapper.reservationDTOToreservation(createReservationDTO);

		Reservation AttachedReservation = reservationRepository.save(reservation);

		return reservationMapper.reservationToReservationDTO(AttachedReservation);

	}

	@Override
	public ReservationDTO modifyReservation(ReservationDTO modifyReservationDTO) throws ReservationNotFoundException {
		Reservation reservation = reservationMapper.reservationDTOToreservation(modifyReservationDTO);
		Integer id = reservation.getId_reservation();
		if (!reservationRepository.existsById(id)) {
			throw new ReservationNotFoundException(String.format("Reserva no encontrado", id));
		}
		MessageDTO messageDTO = resgisterMessage(modifyReservationDTO.getMessageDTO());
		Message message = messageMapper.messageDTOToMessage(messageDTO);
		reservation.setMessage(message);
		Reservation attachedReservation = reservationRepository.save(reservation);
		return reservationMapper.reservationToReservationDTO(attachedReservation);
	}

	@Override
	public MessageDTO resgisterMessage(MessageDTO createMessageDTO) {

		Message message = messageMapper.messageDTOToMessage(createMessageDTO);

		Message AttachedMessage = messageRepository.save(message);

		return messageMapper.messageToMessageDTO(AttachedMessage);
	}

	@Override
	public void removeReservation(Integer id) throws ReservationNotFoundException {
		Optional<Reservation> attachedReservation = reservationRepository.findById(id);
		if (attachedReservation.isEmpty()) {
			throw new ReservationNotFoundException(String.format("Reserva no encontrado", id));
		}
		reservationRepository.deleteById(id);

	}

	@Override
	public ReservationDTO getReservationById(Integer id) throws ReservationNotFoundException {
		Optional<Reservation> reservation = reservationRepository.findById(id);
		if (reservation.isEmpty()) {
			throw new ReservationNotFoundException(String.format("Reserva no encontrado", id));
		}
		return reservationMapper.reservationToReservationDTO(reservation.get());
	}

}
