package com.chandimal.chatapplication.controller;
import com.chandimal.chatapplication.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import static com.chandimal.chatapplication.dto.Status.JOIN;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;


    @MessageMapping("/message") // app/message
    @SendTo("/chatroom")// this is a topic --- destination or channel which can be subscribed to recieve msgs that come in to this channel
    public MessageDTO recievePublicMessage(@Payload MessageDTO message){
        System.out.println(message.getMessage());
        //new MessageDTO("sender" , "reciever", "message" , "date" , JOIN)
        return message ;
    }

    @MessageMapping("/private-message")//app/private-message
    public MessageDTO recievePrivateMessage(@Payload MessageDTO message){
        String user = message.getReceiverName();
        System.out.println(user);
        System.out.println("awa");
        simpMessagingTemplate.convertAndSendToUser(user,"/private",message);
        System.out.println(message.toString());
        return message;
    }



}
