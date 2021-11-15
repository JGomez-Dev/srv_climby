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

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TravelMapper {

	@Mapping(target = "driver", source = "userDTO")
	@Mapping(target = "id_travel", source = "id")
	@Mapping(target = "province", source = "provinceDTO")
	Travel travelDTOToTravel(TravelDTO travelDTO);

	@Mapping(source = "driver", target = "userDTO")
	@Mapping(source = "id_travel", target = "id")
	@Mapping(source = "province", target = "provinceDTO")
	@Mapping(source = "reservation", target = "reservationDTO", qualifiedByName = "mapearReservas")
	TravelDTO travelToTravelDTO(Travel travel);

	@Named("mapearReservas")
	default List<ReservationDTO> mapearReservas(List<Reservation> mapearReservas) {
		List<ReservationDTO> list = new ArrayList<>();
		if(mapearReservas != null) {
			for (Reservation reservation : mapearReservas) {
				ReservationDTO dto = new ReservationDTO();
				dto.setTravelDTO(reservation.getTravel().getId_travel());
				dto.setUserDTO(reservation.getPassenger().getId());
				dto.setCustomerDate(reservation.getReservationDate());
				list.add(dto);
			}
			return list;
		}
		return null;

	}

	List<TravelDTO> listTravelToListTravelDTO(List<Travel> travel);

}
