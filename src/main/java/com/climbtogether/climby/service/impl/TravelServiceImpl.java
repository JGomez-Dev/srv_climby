package com.climbtogether.climby.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.climbtogether.climby.domain.Reservation;
import com.climbtogether.climby.domain.School;
import com.climbtogether.climby.domain.Travel;
import com.climbtogether.climby.domain.User;
import com.climbtogether.climby.dto.SchoolDTO;
import com.climbtogether.climby.dto.TravelDTO;
import com.climbtogether.climby.mapper.SchoolMapper;
import com.climbtogether.climby.mapper.TravelMapper;
import com.climbtogether.climby.repository.SchoolRepository;
import com.climbtogether.climby.repository.TravelRepository;
import com.climbtogether.climby.service.SchoolService;
import com.climbtogether.climby.service.TravelService;

@Service
public class TravelServiceImpl implements TravelService, SchoolService {

	@Autowired
	private TravelRepository travelRepository;
	@Autowired
	private SchoolRepository schoolRepository;

	@Autowired
	private TravelMapper travelMapper;
	@Autowired
	private SchoolMapper schoolMapper;

	@Override
	public TravelDTO resgisterTravel(TravelDTO createTravelDTO) {

		Travel travel = travelMapper.travelDTOToTravel(createTravelDTO);

		Optional<School> school = schoolRepository.findById(createTravelDTO.getSchoolDTO().getName());

		if (school.isEmpty()) {
			resgisterSchool(createTravelDTO.getSchoolDTO());
		} else {
			getSchoolById(createTravelDTO.getSchoolDTO().getName());
		}

		Travel AttachedTravel = travelRepository.save(travel);

		return travelMapper.travelToTravelDTO(AttachedTravel);

	}

	@Override
	public List<TravelDTO> getTravelFindAll(Integer idUser) {
		
		List<Travel> travel = travelRepository.findAllTravels(idUser);

		return travelMapper.listTravelToListTravelDTO(travel);
	}
	

	@Override
	public List<TravelDTO> getTravelsWithUserReservation(Integer idUser) {
		
		List<Travel> travel = travelRepository.getTravelsWithUserReservation(idUser);

		return travelMapper.listTravelToListTravelDTO(travel);
	}

	@Override
	public TravelDTO getTravelById(Integer id) {

		Optional<Travel> travel = travelRepository.findById(id);

		if (!travelRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return travelMapper.travelToTravelDTO(travel.get());
	}

	@Override
	public TravelDTO modifyTravel(TravelDTO modifyTravelDTO) {

		Travel travel = travelMapper.travelDTOToTravel(modifyTravelDTO);

		Optional<School> school = schoolRepository.findById(modifyTravelDTO.getSchoolDTO().getName());

		Integer id = travel.getId_travel();

		if (!travelRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		if (school.isEmpty()) {
			resgisterSchool(modifyTravelDTO.getSchoolDTO());
		} else {
			getSchoolById(modifyTravelDTO.getSchoolDTO().getName());
		}
		
		Travel attachedTravel = travelRepository.save(travel);

		return travelMapper.travelToTravelDTO(attachedTravel);
	}

	@Override
	public void removeTravel(Integer id) {

		Optional<Travel> attachedTravel = travelRepository.findById(id);
		if (attachedTravel.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		travelRepository.deleteById(id);

	}

	@Override
	public SchoolDTO resgisterSchool(SchoolDTO createSchoolDTO) {

		School school = schoolMapper.schoolDTOToSchool(createSchoolDTO);

		School AttachedSchool = schoolRepository.save(school);

		return schoolMapper.schoolToSchoolDTO(AttachedSchool);
	}

	@Override
	public SchoolDTO getSchoolById(String id) {

		Optional<School> school = schoolRepository.findById(id);

		return schoolMapper.schoolToSchoolDTO(school.get());
	}

	@Override
	public List<SchoolDTO> getSchoolFindAll() {

		List<School> school = schoolRepository.findAll();

		return schoolMapper.listSchoolToListSchoolDTO(school);
	}

}
