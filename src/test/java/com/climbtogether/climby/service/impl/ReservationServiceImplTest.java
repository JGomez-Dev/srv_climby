package com.climbtogether.climby.service.impl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.climbtogether.climby.controller.MessageController;
import com.climbtogether.climby.domain.Message;
import com.climbtogether.climby.domain.Reservation;
import com.climbtogether.climby.dto.MessageDTO;
import com.climbtogether.climby.dto.ReservationDTO;
import com.climbtogether.climby.exceptions.ReservationNotFoundException;
import com.climbtogether.climby.mapper.MessageMapper;
import com.climbtogether.climby.mapper.ReservationMapper;
import com.climbtogether.climby.repository.ReservationRepository;
import com.climbtogether.climby.util.ReservationMapperUtil;

@ExtendWith(SpringExtension.class)
public class ReservationServiceImplTest {

	@Mock
	private ReservationRepository reservationRepository;

	@Mock
	private ReservationMapper reservationMapper;

	@Mock
	private MessageMapper messageMapper;

	@Mock
	private MessageController messageController;

	@InjectMocks
	private ReservationServiceImpl reservationServiceImpl = new ReservationServiceImpl();

	@Test
	public void testResgisterReservation() {
		ReservationDTO responseReservationDTO = ReservationMapperUtil
				.generateTestCreationReservationDTO();
		reservationServiceImpl.resgisterReservation(responseReservationDTO);
	}

	@Test
	public void testModifyReservation() throws ReservationNotFoundException {
		ReservationDTO creationRequestDTO = ReservationMapperUtil
				.generateTestCreationReservationDTO();
		Reservation reservation = ReservationMapperUtil
				.generateTestCreationReservation();
		Reservation attachedReservation = ReservationMapperUtil
				.generateTestCreationReservation();
		ReservationDTO responseReservationDTO = ReservationMapperUtil
				.generateTestCreationReservationDTO();
		MessageDTO messageDTO = ReservationMapperUtil
				.generateTestCreationMessageDTO();
		Message message = ReservationMapperUtil.generateTestCreationMessage();
		when(reservationMapper.reservationDTOToreservation(creationRequestDTO))
				.thenReturn(reservation);
		when(reservationRepository.existsById(reservation.getId_reservation()))
				.thenReturn(true);
		when(reservationRepository.save(reservation))
				.thenReturn(attachedReservation);
		when(reservationMapper.reservationToReservationDTO(attachedReservation))
				.thenReturn(responseReservationDTO);
		when(messageController
				.registerMessage(creationRequestDTO.getMessageDTO()))
				.thenReturn(messageDTO);
		when(messageMapper.messageDTOToMessage(messageDTO)).thenReturn(message);
		reservationServiceImpl.modifyReservation(creationRequestDTO);
		when(reservationRepository.existsById(reservation.getId_reservation()))
				.thenReturn(false);

		verify(reservationMapper)
				.reservationDTOToreservation(responseReservationDTO);
		verify(reservationRepository)
				.existsById(reservation.getId_reservation());
		verify(reservationRepository).save(reservation);
		verify(reservationMapper)
				.reservationToReservationDTO(attachedReservation);

	}

//	@Test
//	public void testRemoveReservation() throws ReservationNotFoundException {
//		Reservation creationRequest = ReservationMapperUtil
//				.generateTestCreationReservation();
//		reservationServiceImpl.removeReservation(creationRequest.getId_reservation());
//		reservationRepository.deleteById(creationRequest.getId_reservation());
//		
//
//	}

}
