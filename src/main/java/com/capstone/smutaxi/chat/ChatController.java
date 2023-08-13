package com.capstone.smutaxi.chat;

import com.capstone.smutaxi.KafkaProducerService;
import com.capstone.smutaxi.utils.IDGenerator;
import com.capstone.smutaxi.entity.SystemMessage;
import com.capstone.smutaxi.entity.UserMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final IDGenerator idGenerator;
    private final KafkaProducerService kafkaProducerService;

    @MessageMapping("/send")
    public void userChat(UserMessage message) {
        message.setId(idGenerator.getNextId());
        kafkaProducerService.sendUserMessage(message);
        messagingTemplate.convertAndSend("/sub/channel/" + message.getChatRoom().getId(), message);
    }

    @MessageMapping("/exit")
    public void exitChat(SystemMessage message) {
        message.setId(idGenerator.getNextId());
        message.setMessage(message.getSenderName() + "님이 나갔습니다.");
        message.setIsSystem(true);

        kafkaProducerService.sendSystemMessage(message);
        messagingTemplate.convertAndSend("/sub/channel/" + message.getChatRoom().getId(), message);
    }
}