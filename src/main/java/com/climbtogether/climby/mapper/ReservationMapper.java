package com.climbtogether.climby.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.climbtogether.climby.domain.Reservation;
import com.climbtogether.climby.dto.ReservationDTO;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

	
	
	@Mapping(target= "id_reservation",source = "id")
	@Mapping(target= "passenger.id_user",source = "userDTO.id")
	@Mapping(target= "passenger.token",source = "userDTO.token")
	@Mapping(target= "travel.id_travel",source = "travelDTO")
	@Mapping(target= "reservationDate",source = "customerDate")
	@Mapping(target= "passenger.ratings",source = "userDTO.ratings")
	@Mapping(target= "message",source = "messageDTO")
	Reservation reservationDTOToreservation(ReservationDTO reservationDTO);


	@Mapping(source= "id_reservation",target = "id")
	@Mapping(source= "passenger.id_user",target = "userDTO.id")
	@Mapping(source= "passenger.token",target = "userDTO.token")
	@Mapping(source= "travel.id_travel",target = "travelDTO")
	@Mapping(source= "reservationDate",target = "customerDate")
	@Mapping(source= "passenger.ratings",target = "userDTO.ratings")
	@Mapping(source= "message",target = "messageDTO")
	ReservationDTO reservationToReservationDTO(Reservation reservation);
	
	

	
}