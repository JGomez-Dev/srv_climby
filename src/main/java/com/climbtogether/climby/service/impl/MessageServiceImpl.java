package com.climbtogether.climby.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.climbtogether.climby.domain.Message;
import com.climbtogether.climby.domain.Reservation;
import com.climbtogether.climby.domain.Travel;
import com.climbtogether.climby.dto.MessageDTO;
import com.climbtogether.climby.dto.ReservationDTO;
import com.climbtogether.climby.exceptions.ReservationNotFoundException;
import com.climbtogether.climby.exceptions.TravelNotFoundException;
import com.climbtogether.climby.mapper.MessageMapper;
import com.climbtogether.climby.repository.MessageRepository;
import com.climbtogether.climby.repository.TravelRepository;
import com.climbtogether.climby.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageMapper messageMapper;

	@Autowired
	private MessageRepository messageRepository;
	

	@Autowired
	private TravelRepository travelRepository;

	@Override
	public MessageDTO resgisterMessage(MessageDTO createMessageDTO) {

		Message message = messageMapper.messageDTOToMessage(createMessageDTO);

		Message AttachedMessage = messageRepository.save(message);

		return messageMapper.messageToMessageDTO(AttachedMessage);
	}

	@Override
	public List<MessageDTO> modifyMessageByTravelId(Integer id)
			throws TravelNotFoundException {
		Optional<Travel> travel = travelRepository.findById(id);
		List<MessageDTO> messages = new ArrayList<MessageDTO>();
	        if (travel.isPresent()) {
	        	for(Reservation reservations: travel.get().getReservation()) {
	        		MessageDTO messageDTO = messageMapper.messageToMessageDTO(reservations.getMessage());
	        		if(messageDTO.getRead()== false) {
	        			messageDTO.setRead(true);
	        			Message message = messageMapper.messageDTOToMessage(messageDTO);
	        			messageRepository.save(message);
	        			messages.add(messageDTO);
	        		}
	        		
	        		
	        	}
	           return messages;
	        } else {
	            return messages;
	        }

	}
	


}
