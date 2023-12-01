package com.example.quotopiabackend.dto.dtoUser;

import com.example.quotopiabackend.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserPasswordConverter {
    public User toUserPasswordModel(UserPasswordDTO userPasswordDTO) {
        return new User(userPasswordDTO.userID(),
                userPasswordDTO.userEmail(),
                userPasswordDTO.userName(),
                userPasswordDTO.isAdmin(),
                userPasswordDTO.userPassword());

    }

}
