package com.capstone.smutaxi;

import com.capstone.smutaxi.domain.Message;
import com.capstone.smutaxi.domain.SystemMessage;
import com.capstone.smutaxi.domain.UserMessage;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



@Component
public class ApiClient {

    private final RestTemplate restTemplate;

    public ApiClient() {
        this.restTemplate = new RestTemplate();
    }

    public UserMessage saveUserMessage(Message data) {
        String apiUrl = "http://localhost:8080/api/chat/save-user"; // API 서버의 엔드포인트 URL
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        // HTTP 요청 본문에 데이터를 담아 전송
        HttpEntity<Message> requestEntity = new HttpEntity<>(data, headers);

        // POST 요청을 보내고 응답 받기
        ResponseEntity<UserMessage> responseEntity = restTemplate.exchange(
                apiUrl, HttpMethod.POST, requestEntity, UserMessage.class);

        return responseEntity.getBody();
    }

    public SystemMessage saveSystemMessage(Message data) {
        String apiUrl = "http://localhost:8080/api/chat/save-exit"; // API 서버의 엔드포인트 URL
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        // HTTP 요청 본문에 데이터를 담아 전송
        HttpEntity<Message> requestEntity = new HttpEntity<>(data, headers);

        // POST 요청을 보내고 응답 받기
        ResponseEntity<SystemMessage> responseEntity = restTemplate.exchange(
                apiUrl, HttpMethod.POST, requestEntity, SystemMessage.class);

        return responseEntity.getBody();
    }
}
