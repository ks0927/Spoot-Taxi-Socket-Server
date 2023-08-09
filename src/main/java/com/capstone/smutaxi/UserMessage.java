package com.capstone.smutaxi;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserMessage extends Message{
    private String senderEmail;
    private String senderProfileImageUrl;

    @Override
    public String toString() {
        return "UserMessage{" +
                "senderEmail='" + senderEmail + '\'' +
                ", senderProfileImageUrl='" + senderProfileImageUrl + '\'' +
                '}';
    }
}
