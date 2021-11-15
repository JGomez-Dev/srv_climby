package com.climbtogether.climby.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import com.climbtogether.climby.domain.Reservation;
import com.climbtogether.climby.dto.ReservationDTO;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ReservationMapper {

	
	@Mapping(target= "passenger.id_user",source = "userDTO.id")
	@Mapping(target= "travel.id_travel",source = "travelDTO")
	@Mapping(target= "reservationDate",source = "customerDate")
	Reservation reservationDTOToreservation(ReservationDTO reservationDTO);

//	@Named("mapearPasajeros")
//    default List<String> mapeoIdReserva(List<ReservationDTO> mapearReservas) {
//		List<String> reservaId = new ArrayList<String>();
//		for (ReservationDTO id : mapearReservas){
//			reservaId.add(id.getId());
//		}
//		
//        return reservaId;              
//    }
	@Mapping(source= "id_reservation",target = "id")
	@Mapping(source= "passenger.id_user",target = "userDTO.id")
	@Mapping(source= "travel.id_travel",target = "travelDTO")
	@Mapping(source= "reservationDate",target = "customerDate")
	ReservationDTO reservationToReservationDTO(Reservation reservation);
	
	
	

	
}