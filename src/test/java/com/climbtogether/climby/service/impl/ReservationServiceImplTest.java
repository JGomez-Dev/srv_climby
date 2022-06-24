//package com.climbtogether.climby.service.impl;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import com.climbtogether.climby.controller.UserController;
//import com.climbtogether.climby.domain.Reservation;
//import com.climbtogether.climby.dto.ReservationDTO;
//import com.climbtogether.climby.mapper.MessageMapper;
//import com.climbtogether.climby.mapper.ReservationMapper;
//import com.climbtogether.climby.repository.ReservationRepository;
//import com.climbtogether.climby.repository.TravelRepository;
//import com.climbtogether.climby.util.GenerateObjecTestUtil;
//
//@RunWith(MockitoJUnitRunner.class)
//public class ReservationServiceImplTest {
//
//	@Mock
//	private ReservationRepository reservationRepository = mock(ReservationRepository.class);
//
//	@Mock
//	private TravelRepository travelRepository = mock(TravelRepository.class);
//
//	@Mock
//	private ReservationMapper reservationMapper = mock(ReservationMapper.class);
//
//	@Mock
//	private MessageController messageController = mock(MessageController.class);
//
//	@Mock
//	private MessageMapper messageMapper = mock(MessageMapper.class);
//
//	@Mock
//	private UserController userController = mock(UserController.class);
//
//	@Mock
//	ReservationServiceImpl reservationServiceImpl =  mock(ReservationServiceImpl.class);
//
//	
//	@Test
//	public void testResgisterReservation() {
//		ReservationDTO reservationDTO = GenerateObjecTestUtil.generateTestCreationReservationDTO();
//		Reservation reservation = GenerateObjecTestUtil.generateTestCreationReservation();
//		Reservation attachedItem = GenerateObjecTestUtil.generateTestCreationReservation();
//		
//		 when(reservationMapper.reservationDTOToreservation(reservationDTO)).thenReturn(reservation);
//		
//	}
//
//}
