package com.climbtogether.climby.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.climbtogether.climby.domain.Message;
import com.climbtogether.climby.dto.MessageDTO;
import com.climbtogether.climby.mapper.MessageMapper;
import com.climbtogether.climby.repository.MessageRepository;
import com.climbtogether.climby.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageMapper messageMapper;
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Override
	public MessageDTO resgisterMessage(MessageDTO createMessageDTO) {
		
		Message message = messageMapper.messageDTOToMessage(createMessageDTO);
		
		Message AttachedMessage = messageRepository.save(message);

		return messageMapper.messageToMessageDTO(AttachedMessage);
	}
	

}
