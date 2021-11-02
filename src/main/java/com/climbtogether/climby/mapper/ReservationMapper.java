package com.climbtogether.climby.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.climbtogether.climby.domain.Reservation;
import com.climbtogether.climby.dto.ReservationDTO;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ReservationMapper {

	@Mapping(source = "id", target = "id")
	Reservation reservationDTOToreservation(ReservationDTO reservationDTO);

	@Mapping(target = "userDTO.id", source = "passenger.id")
	@Mapping(target = "id", source = "id")
	ReservationDTO reservationToReservationDTO(Reservation reservation);

	

}