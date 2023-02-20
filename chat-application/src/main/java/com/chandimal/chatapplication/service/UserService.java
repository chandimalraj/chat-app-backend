package com.chandimal.chatapplication.service;

import com.chandimal.chatapplication.dto.UserDTO;

import java.util.List;

public interface UserService {

    String saveUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();

    String saveUserImage(String email, String imgUrl);
}
