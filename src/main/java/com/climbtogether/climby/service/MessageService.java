package com.climbtogether.climby.service;

import java.util.List;

import com.climbtogether.climby.dto.MessageDTO;
import com.climbtogether.climby.exceptions.TravelNotFoundException;

public interface MessageService {
	
	MessageDTO resgisterMessage(MessageDTO createMessageDTO);
	
	List<MessageDTO> modifyMessageByTravelId(Integer id) throws TravelNotFoundException;
		
}
