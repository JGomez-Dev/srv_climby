package com.climbtogether.climby.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.climbtogether.climby.domain.User;
import com.climbtogether.climby.dto.UserDTO;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
	

	@Mapping(target ="id_user",source= "id")
	User userDTOToUser(UserDTO userDTO);
	

	@Mapping(source ="id_user",target= "id")
	UserDTO userToUserDTO(User user);

		

}
