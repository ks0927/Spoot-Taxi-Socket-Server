package com.capstone.smutaxi.chat;

import com.capstone.smutaxi.ApiClient;
import com.capstone.smutaxi.utils.IDGenerator;
import com.capstone.smutaxi.domain.Message;
import com.capstone.smutaxi.domain.SystemMessage;
import com.capstone.smutaxi.domain.UserMessage;
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
    private final ApiClient apiClient;
    private final IDGenerator idGenerator;

    @MessageMapping("/send")
    public void userChat(UserMessage message) {
        message.setId(idGenerator.getNextId());
        Message sendUserMessage = apiClient.saveUserMessage(message);
        messagingTemplate.convertAndSend("/sub/channel/" + message.getChatRoom().getId(), sendUserMessage);
    }

    @MessageMapping("/exit")
    public void exitChat(SystemMessage systemMessage) {
        systemMessage.setId(idGenerator.getNextId());
        systemMessage.setMessage(systemMessage.getSenderName() + "님이 나갔습니다.");
        systemMessage.setIsSystem(true);

        Message sendExitMessage = apiClient.saveSystemMessage(systemMessage);
        messagingTemplate.convertAndSend("/sub/channel/" + systemMessage.getChatRoom().getId(), sendExitMessage);
    }
}