package com.chandimal.chatapplication.util.mappers;


import com.chandimal.chatapplication.dto.UserDTO;
import com.chandimal.chatapplication.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    List<UserDTO> userListToUserDTOList(List<User> userList);


}
