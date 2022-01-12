package com.climbtogether.climby.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.climbtogether.climby.domain.Reservation;
import com.climbtogether.climby.domain.Travel;
import com.climbtogether.climby.dto.ReservationDTO;
import com.climbtogether.climby.dto.TravelDTO;
import com.climbtogether.climby.dto.UserDTO;

@Mapper(componentModel = "spring")
public interface TravelMapper {

	@Mapping(target = "driver.id_user", source = "userDTO.id")
	@Mapping(target = "driver.token", source = "userDTO.token")
	@Mapping(target = "id_travel", source = "id")
	@Mapping(target = "school", source = "schoolDTO.name")
	@Mapping(target = "province.name", source = "provinceDTO.name")
	@Mapping(target = "type", source = "type.name")
	
	@Mapping(target = "reservation", source = "reservationDTO", qualifiedByName = "mapearReservasReservationDTOToReservation")
	Travel travelDTOToTravel(TravelDTO travelDTO);
	

	@Named("mapearReservasReservationDTOToReservation")
	default List<Reservation> mapearReservasReservationDTOToReservation(List<ReservationDTO> mapearReservas) {
		List<Reservation> list = new ArrayList<>();
		
		return list;

	}
	

	@Mapping(source = "driver.id_user", target = "userDTO.id")
	@Mapping(source = "driver.token", target = "userDTO.token")
	@Mapping(source = "id_travel", target = "id")
	@Mapping(source = "school", target = "schoolDTO.name")
	@Mapping(source = "province.name", target = "provinceDTO.name")
	@Mapping(source = "type", target = "type.name")
	@Mapping(source = "reservation", target = "reservationDTO", qualifiedByName = "mapearReservasReservationToReservationDTO")
	TravelDTO travelToTravelDTO(Travel travel);

	@Named("mapearReservasReservationToReservationDTO")
	default List<ReservationDTO> mapearReservasReservationToReservationDTO(List<Reservation> mapearReservas) {
		List<ReservationDTO> list = new ArrayList<>();
		if(mapearReservas != null) {
			for (Reservation reservation : mapearReservas) {
				ReservationDTO reservationDTO = new ReservationDTO();
				UserDTO userDTO = new UserDTO();
				if(reservation.getPassenger()!=null) {
					userDTO.setId(reservation.getPassenger().getId_user());
					userDTO.setToken(reservation.getPassenger().getToken());
					userDTO.setFullName(reservation.getPassenger().getFullName());
					userDTO.setEmail(reservation.getPassenger().getEmail());
					userDTO.setExperience(reservation.getPassenger().getExperience());
					userDTO.setOutputs(reservation.getPassenger().getOutputs());
					userDTO.setPhone(reservation.getPassenger().getPhone());
					userDTO.setScore(reservation.getPassenger().getScore());
					userDTO.setUserPhoto(reservation.getPassenger().getUserPhoto());
					userDTO.setRatings(reservation.getPassenger().getRatings());
					userDTO.setRegistrationDate(reservation.getPassenger().getRegistrationDate());
					reservationDTO.setUserDTO(userDTO);
				}else
					reservationDTO.setUserDTO(null);
				
				reservationDTO.setId(reservation.getId_reservation());
				reservationDTO.setTravelDTO(reservation.getTravel().getId_travel());
				reservationDTO.setCustomerDate(reservation.getReservationDate());
				reservationDTO.setReservationStatus(reservation.getReservationStatus());
				reservationDTO.setValuationStatus(reservation.getValuationStatus());
				
				list.add(reservationDTO);
			}
			return list;
		}
		return null;

	}
	List<TravelDTO> listTravelToListTravelDTO(List<Travel> travel);

}
