//package com.climbtogether.climby.mapper;
//
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.ReportingPolicy;
//
//import com.climbtogether.climby.domain.Reservation;
//import com.climbtogether.climby.dto.ReservationDTO;
//
//@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
//public interface ReservationMapper {
//
////	@Mapping(target= "passenger.id",source = "userDTO.id")
////	Reservation reservationDTOToreservation(ReservationDTO reservationDTO);
//
////	@Named("mapearPasajeros")
////    default List<String> mapeoIdReserva(List<ReservationDTO> mapearReservas) {
////		List<String> reservaId = new ArrayList<String>();
////		for (ReservationDTO id : mapearReservas){
////			reservaId.add(id.getId());
////		}
////		
////        return reservaId;              
////    }
//
//	
//	
////	@Mapping(target= " userDTO",source = "passenger.id", qualifiedByName="Pasajeros")
//	ReservationDTO reservationToReservationDTO(Reservation reservation);
//
//	
//}