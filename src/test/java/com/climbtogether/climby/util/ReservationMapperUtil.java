package com.climbtogether.climby.util;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.climbtogether.climby.domain.ClimbingType;
import com.climbtogether.climby.domain.Message;
import com.climbtogether.climby.domain.Province;
import com.climbtogether.climby.domain.Reservation;
import com.climbtogether.climby.domain.School;
import com.climbtogether.climby.domain.Travel;
import com.climbtogether.climby.domain.User;
import com.climbtogether.climby.dto.ClimbingTypeDTO;
import com.climbtogether.climby.dto.MessageDTO;
import com.climbtogether.climby.dto.ProvinceDTO;
import com.climbtogether.climby.dto.ReservationDTO;
import com.climbtogether.climby.dto.SchoolDTO;
import com.climbtogether.climby.dto.TravelDTO;
import com.climbtogether.climby.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class ReservationMapperUtil {

	public static ReservationDTO generateTestCreationReservationDTO() {
		ReservationDTO reservationDTO = new ReservationDTO();
		reservationDTO.setCustomerDate(generateDate());
		reservationDTO.setId(1);
		reservationDTO.setMessageDTO(generateTestCreationMessageDTO());
		reservationDTO.setReservationStatus(false);
		reservationDTO.setTravelDTO(generateTestCreationTravelDTO());
		reservationDTO.setUserDTO(generateTestCreationUserDTO());
		reservationDTO.setValuationStatus(true);

		return reservationDTO;
	}
	public static Reservation generateTestCreationReservation() {
		Reservation reservation = new Reservation();
		reservation.setReservationDate(generateDate());
		reservation.setId_reservation(1);
		reservation.setMessage(generateTestCreationMessage());
		reservation.setReservationStatus(false);
		reservation.setTravel(generateTestCreationTravel());
		reservation.setPassenger(generateTestCreationUser());
		reservation.setValuationStatus(true);

		return reservation;
	}
	public static MessageDTO generateTestCreationMessageDTO() {
		MessageDTO messageDTO = new MessageDTO();
		messageDTO.setId_message(1);
		messageDTO.setRead(true);
		messageDTO.setTextMessage("Mensaje prueba");
		return messageDTO;

	}
	public static TravelDTO generateTestCreationTravelDTO() {
		TravelDTO travelDTO = new TravelDTO();
		ReservationDTO reservationDTO = new ReservationDTO();
		List<ReservationDTO> listReservationDTO = new ArrayList<ReservationDTO>();
		listReservationDTO.add(reservationDTO);
		travelDTO.setAvailablePlaces(2);
		travelDTO.setDepartureDate(generateDate());
		travelDTO.setId(1);
		travelDTO.setProvinceDTO(generateTestCreationProvinceDTO());
		travelDTO.setReservationDTO(listReservationDTO);
		travelDTO.setSchoolDTO(generateTestCreationSchoolDTO());
		travelDTO.setType(generateTestCreationClimbingTypeDTO());
		travelDTO.setUserDTO(generateTestCreationUserDTO());

		return travelDTO;

	}
	public static SchoolDTO generateTestCreationSchoolDTO() {
		SchoolDTO schoolDTO = new SchoolDTO();
		schoolDTO.setName("Albarracin");

		return schoolDTO;

	}
	public static ClimbingTypeDTO generateTestCreationClimbingTypeDTO() {
		ClimbingTypeDTO climbingTypeDTO = new ClimbingTypeDTO();
		climbingTypeDTO.setName("Cuerda");

		return climbingTypeDTO;

	}

	public static UserDTO generateTestCreationUserDTO() {

		UserDTO userDTO = new UserDTO();
		userDTO.setEmail("perico@gmail.com");
		userDTO.setExperience("Intermedio");
		userDTO.setFullName("Perico De Los Palotes");
		userDTO.setId(1);
		userDTO.setOutputs(2);
		userDTO.setPhone("691222222");
		userDTO.setRatings(1);
		userDTO.setRegistrationDate(generateDate());
		userDTO.setScore(new BigDecimal(0.01));
		userDTO.setToken("160");
		userDTO.setUserPhoto("Foto");
		return userDTO;

	}

	public static ProvinceDTO generateTestCreationProvinceDTO() {
		ProvinceDTO provinceDTO = new ProvinceDTO();
		provinceDTO.setName("Murcia");

		return provinceDTO;

	}

	public static Message generateTestCreationMessage() {
		Message message = new Message();
		message.setId_message(1);
		message.setRead(true);
		message.setTextMessage("Mensaje prueba");
		return message;

	}
	public static Travel generateTestCreationTravel() {
		Travel travel = new Travel();
		Reservation reservation = new Reservation();
		List<Reservation> listReservation = new ArrayList<Reservation>();
		listReservation.add(reservation);
		travel.setAvailablePlaces(2);
		travel.setDepartureDate(generateDate());
		travel.setId_travel(1);
		travel.setProvince(generateTestCreationProvince());
		travel.setReservation(listReservation);
		travel.setSchool(generateTestCreationSchool());
		travel.setType(generateTestCreationClimbingType());
		travel.setDriver(generateTestCreationUser());

		return travel;

	}
	public static School generateTestCreationSchool() {
		School school = new School();
		school.setName("Albarracin");

		return school;

	}
	public static ClimbingType generateTestCreationClimbingType() {
		ClimbingType climbingType = new ClimbingType();
		climbingType.setName("Cuerda");

		return climbingType;

	}

	public static User generateTestCreationUser() {

		User user = new User();
		user.setEmail("perico@gmail.com");
		user.setExperience("Intermedio");
		user.setFullName("Perico De Los Palotes");
		user.setId_user(1);;
		user.setOutputs(2);
		user.setPhone("691222222");
		user.setRatings(1);
		user.setRegistrationDate(generateDate());
		user.setScore(new BigDecimal(0.01));
		user.setToken("160");
		user.setUserPhoto("Foto");
		return user;

	}

	public static Province generateTestCreationProvince() {
		Province province = new Province();
		province.setName("Murcia");

		return province;

	}

	public static LocalDateTime generateDate() {
		LocalDateTime localDateTime = LocalDateTime
				.parse("2018-02-27T18:14:01.184");
		return localDateTime;

	}
}
