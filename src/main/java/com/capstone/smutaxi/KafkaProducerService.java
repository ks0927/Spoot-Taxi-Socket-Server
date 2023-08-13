package com.capstone.smutaxi;

import com.capstone.smutaxi.entity.SystemMessage;
import com.capstone.smutaxi.entity.UserMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, UserMessage> kafkaTemplateUserMessage;
    private final KafkaTemplate<String, SystemMessage> kafkaTemplateSystemMessage;

    public void sendUserMessage(UserMessage message) {
        System.out.println("message = " + message.toString());
        kafkaTemplateUserMessage.send("user-message-topic", message);
    }

    public void sendSystemMessage(SystemMessage message) {
        System.out.println("message = " + message.toString());
        kafkaTemplateSystemMessage.send("system-message-topic", message);
    }
}
