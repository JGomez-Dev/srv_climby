//package com.climbtogether.climby.mapper;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//
//import com.climbtogether.climby.domain.Travel;
//import com.climbtogether.climby.dto.TravelDTO;
//import com.climbtogether.climby.util.ReservationMapperUtil;
//
//public class TravelMapperTest {
//	@Mock
//	TravelMapper travelMapper = mock(TravelMapper.class);
//	@Test
//	void testTravelDTOToTravel() {
//		Travel travel = ReservationMapperUtil.generateTestCreationTravel();
//		TravelDTO travelDTO = ReservationMapperUtil.generateTestCreationTravelDTO();
//		
//		when(travelMapper.travelDTOToTravel(travelDTO)).thenReturn(travel);
//	}
//}
