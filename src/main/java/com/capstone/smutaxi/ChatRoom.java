package com.capstone.smutaxi;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class ChatRoom  {

    private Long id;

    private String chatRoomName;

    private List<Message> messageList = new ArrayList<>();

}