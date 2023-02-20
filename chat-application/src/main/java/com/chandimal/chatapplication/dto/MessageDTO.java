package com.chandimal.chatapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {

    private String senderName;
    private String receiverName;
    private String message;
    private String date;
    private Status status;

}
