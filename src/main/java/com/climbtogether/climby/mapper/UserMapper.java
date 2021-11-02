package com.climbtogether.climby.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.climbtogether.climby.domain.User;
import com.climbtogether.climby.dto.UserDTO;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
	

	//@Mapping(target ="reservation",source= "reservationDTO", qualifiedByName="mapearReservas")
	User userDTOToUser(UserDTO userDTO);
	
//	@Named("mapearReservas")
//    default List<String> mapeoIdReserva(List<ReservationDTO> mapearReservas) {
//		List<String> reservaId = new ArrayList<String>();
//		for (ReservationDTO id : mapearReservas){
//			reservaId.add(id.getId());
//		}
//		
//        return reservaId;              
//    }
	
	UserDTO userToUserDTO(User user);

		

}
