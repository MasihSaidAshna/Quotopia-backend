package com.example.quotopiabackend.dto.dtoUser;


import com.example.quotopiabackend.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {


    public UserDTO toUserDTO(User user) {
        return new UserDTO(user.getUserId(), user.getUserName(), user.getUserEmail());
    }

    public User toUser(UserDTO userDTO) {
        return new User(userDTO.userId(), userDTO.userName(), userDTO.userEmail());
    }
}