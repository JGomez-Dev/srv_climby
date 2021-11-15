package com.climbtogether.climby.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import com.climbtogether.climby.domain.Reservation;
import com.climbtogether.climby.domain.Travel;
import com.climbtogether.climby.dto.ReservationDTO;
import com.climbtogether.climby.dto.TravelDTO;
import com.climbtogether.climby.dto.UserDTO;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TravelMapper {

	@Mapping(target = "driver.id_user", source = "userDTO.id")
	@Mapping(target = "id_travel", source = "id")
	@Mapping(target = "province", source = "provinceDTO")
	Travel travelDTOToTravel(TravelDTO travelDTO);

	@Mapping(source = "driver.id_user", target = "userDTO.id")
	@Mapping(source = "id_travel", target = "id")
	@Mapping(source = "province", target = "provinceDTO")
	@Mapping(source = "reservation", target = "reservationDTO", qualifiedByName = "mapearReservas")
	TravelDTO travelToTravelDTO(Travel travel);

	@Named("mapearReservas")
	default List<ReservationDTO> mapearReservas(List<Reservation> mapearReservas) {
		List<ReservationDTO> list = new ArrayList<>();
		if(mapearReservas != null) {
			for (Reservation reservation : mapearReservas) {
				ReservationDTO reservationDTO = new ReservationDTO();
				UserDTO userDTO = new UserDTO();
				if(reservation.getPassenger()!=null) {
					userDTO.setId(reservation.getPassenger().getId_user());
					userDTO.setFullName(reservation.getPassenger().getFullName());
					userDTO.setEmail(reservation.getPassenger().getEmail());
					userDTO.setExperience(reservation.getPassenger().getExperience());
					userDTO.setOutputs(reservation.getPassenger().getOutputs());
					userDTO.setPhone(reservation.getPassenger().getPhone());
					userDTO.setScore(reservation.getPassenger().getScore());
					userDTO.setUserPhoto(reservation.getPassenger(). getUserPhoto());	
					reservationDTO.setUserDTO(userDTO);
				}else
					reservationDTO.setUserDTO(null);
				
				reservationDTO.setId(reservation.getId_reservation());
				reservationDTO.setTravelDTO(reservation.getTravel().getId_travel());
				reservationDTO.setCustomerDate(reservation.getReservationDate());
				list.add(reservationDTO);
			}
			return list;
		}
		return null;

	}
	List<TravelDTO> listTravelToListTravelDTO(List<Travel> travel);

}
