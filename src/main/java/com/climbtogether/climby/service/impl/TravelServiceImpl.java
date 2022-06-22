package com.climbtogether.climby.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.climbtogether.climby.domain.School;
import com.climbtogether.climby.domain.Travel;
import com.climbtogether.climby.dto.SchoolDTO;
import com.climbtogether.climby.dto.TravelDTO;
import com.climbtogether.climby.exceptions.TravelNotFoundException;
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

	// Devuelve todos los viajes
	@Override
	public List<TravelDTO> getTravelFindAll() {

		List<Travel> travel = travelRepository.findAll();

		return travelMapper.listTravelToListTravelDTO(travel);
	}

	// Devuelve todos los viajes de un usuario determinado
	@Override
	public List<TravelDTO> getUsersTravels(Integer id) {
		List<Travel> travel = travelRepository.getUsersTravels(id);

		return travelMapper.listTravelToListTravelDTO(travel);
	}

	// Muestra los viajes que tengan reservas de un determinado usuario o el
	// usuario sea el creador del viaje
	@Override
	public List<TravelDTO> getTravelsWithUserReservation(Integer idUser) {

		List<Travel> travels = travelRepository
				.getTravelsWithUserReservation(idUser);

		travels = travels.stream().distinct().collect(Collectors.toList());
		
		return travelMapper.listTravelToListTravelDTO(travels);
	}

	@Override
	public TravelDTO resgisterTravel(TravelDTO createTravelDTO) {

		Travel travel = travelMapper.travelDTOToTravel(createTravelDTO);

		Optional<School> school = schoolRepository
				.findById(createTravelDTO.getSchoolDTO().getName());

		if (school.isEmpty()) {
			resgisterSchool(createTravelDTO.getSchoolDTO());
		} else {
			getSchoolById(createTravelDTO.getSchoolDTO().getName());
		}

		Travel AttachedTravel = travelRepository.save(travel);

		return travelMapper.travelToTravelDTO(AttachedTravel);

	}

	@Override
	public TravelDTO modifyTravel(TravelDTO modifyTravelDTO)
			throws TravelNotFoundException {

		Travel travel = travelMapper.travelDTOToTravel(modifyTravelDTO);

		Optional<School> school = schoolRepository
				.findById(modifyTravelDTO.getSchoolDTO().getName());

		Integer id = travel.getId_travel();

		if (!travelRepository.existsById(id)) {
			throw new TravelNotFoundException(
					String.format("Viaje no encontrado", id));
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
	public void removeTravel(Integer id) throws TravelNotFoundException {

		Optional<Travel> attachedTravel = travelRepository.findById(id);
		if (attachedTravel.isEmpty()) {
			throw new TravelNotFoundException(
					String.format("Viaje no encontrado", id));
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

	@Override
	public TravelDTO getTravelById(Integer id) throws TravelNotFoundException {

		Optional<Travel> travel = travelRepository.findById(id);

		if (travel.isEmpty()) {
			throw new TravelNotFoundException(
					String.format("Viaje no encontrado", id));
		}

		return travelMapper.travelToTravelDTO(travel.get());
	}

}
