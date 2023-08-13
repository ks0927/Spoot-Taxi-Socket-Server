package com.capstone.smutaxi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Message {

    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime sendTime;

    private String message;

    private String senderName;

    private ChatRoom chatRoom;

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", sendTime=" + sendTime +
                ", message='" + message + '\'' +
                ", senderName='" + senderName + '\'' +
                ", chatRoom=" + chatRoom +
                '}';
    }
}