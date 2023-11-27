package com.example.quotopiabackend.dto.dtoUser;


import com.example.quotopiabackend.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {


    public UserDTO toUserDTO(User user) {
        return new UserDTO(user.getUserID(), user.getUserName(), user.getUserEmail());
    }

    public User toUserModel(UserDTO userDTO) {
        return new User(userDTO.userID(), userDTO.userName(), userDTO.userEmail());
    }
}