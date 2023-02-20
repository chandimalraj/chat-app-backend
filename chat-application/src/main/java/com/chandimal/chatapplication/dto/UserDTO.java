package com.chandimal.chatapplication.dto;


import lombok.Data;

@Data
public class UserDTO {

    private int id;
    private String username;
    private String email;
    private String phone;
    private String password;
    private String imageUrl;


}
