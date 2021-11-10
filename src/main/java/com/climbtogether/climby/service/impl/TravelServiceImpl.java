package com.climbtogether.climby.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.climbtogether.climby.domain.Travel;
import com.climbtogether.climby.dto.TravelDTO;
import com.climbtogether.climby.mapper.TravelMapper;
import com.climbtogether.climby.repository.TravelRepository;
import com.climbtogether.climby.service.TravelService;

@Service
public class TravelServiceImpl implements TravelService {

	private static final String MESSAGE_TRAVEL_NOT_FOUND = "Province id \"%s\" not found";
	private static final String MESSAGE_TRAVEL_ID_NULL = "Province id must not be null";

	@Autowired
	private TravelRepository travelRepository;

	@Autowired
	private TravelMapper travelMapper;

	@Override
	public TravelDTO resgisterTravel(TravelDTO createTravelDTO) {

		Travel travel = travelMapper.travelDTOToTravel(createTravelDTO);

		Travel AttachedTravel = travelRepository.save(travel);

		return travelMapper.travelToTravelDTO(AttachedTravel);

	}

	@Override
	public List<TravelDTO> getTravelFindAll() {

		List<Travel> travel = travelRepository.findAll();

		return travelMapper.listTravelToListTravelDTO(travel);
	}

	@Override
	public TravelDTO getTravelById(Integer id) {

		Optional<Travel> travel = travelRepository.findById(id);

		return travelMapper.travelToTravelDTO(travel.get());
	}

	@Override
	public TravelDTO modifyTravel(TravelDTO modifyTravelDTO) {

		Travel travel = travelMapper.travelDTOToTravel(modifyTravelDTO);
		Integer id = travel.getId_travel();
		Assert.notNull(id, MESSAGE_TRAVEL_ID_NULL);
		if (!travelRepository.existsById(id)) {
			// Hay que meter una excepcion
			return null;
		}

		Travel attachedTravel = travelRepository.save(travel);

		return travelMapper.travelToTravelDTO(attachedTravel);
	}

	@Override
	public void removeTravel(Integer id) {
		Assert.notNull(id, MESSAGE_TRAVEL_ID_NULL);
		Optional<Travel> attachedTravel = travelRepository.findById(id);
		if (attachedTravel.isEmpty()) {
			// Excepcion
		}
		travelRepository.deleteById(id);

	}

}
