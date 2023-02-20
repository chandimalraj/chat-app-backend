package com.chandimal.chatapplication.service.impl;


import com.chandimal.chatapplication.dto.UserDTO;
import com.chandimal.chatapplication.entity.User;
import com.chandimal.chatapplication.repo.UserRepo;
import com.chandimal.chatapplication.service.UserService;
import com.chandimal.chatapplication.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String saveUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO,User.class);
        userRepo.save(user);
        return "saved";
    }

    @Override
    public List<UserDTO> getAllUsers() {

        List<User> userList = userRepo.findAll();
        List<UserDTO> userDTOList = itemMapper.userListToUserDTOList(userList);
        return userDTOList;
    }

    @Override
    @Transactional
    public String saveUserImage(String email, String imgUrl) {

        userRepo.updateImgUrlByEmail(imgUrl,email);
        return "saved img url";
    }
}
