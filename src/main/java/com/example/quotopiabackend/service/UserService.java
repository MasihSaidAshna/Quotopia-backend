package com.example.quotopiabackend.service;

import com.example.quotopiabackend.dto.dtoUser.UserDTO;
import com.example.quotopiabackend.dto.dtoUser.UserPasswordDTO;
import com.example.quotopiabackend.model.User;
import com.example.quotopiabackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserById(int userID) {
        return userRepository.findById(userID);
    }

    public User saveUser(UserDTO userDTO) {
        User newUser = new User();
        newUser.setUserName(userDTO.userName());
        newUser.setUserEmail(userDTO.userEmail());
        return userRepository.save(newUser);

    }

    public User saveUserWithPassword(UserPasswordDTO userPasswordDTO) {
        User newUser = new User();
        newUser.setUserName(userPasswordDTO.userName());
        newUser.setUserPassword(userPasswordDTO.userEmail());
        newUser.setUserPassword(userPasswordDTO.userPassword());
        return userRepository.save(newUser);

    }

    public User updateUser(int userID, UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findById(userID);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setUserName(userDTO.userName());
            existingUser.setUserEmail(userDTO.userEmail());
            return userRepository.save(existingUser);
        }
        return null;
    }

    public List<UserDTO> getAllUser() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserDTO(user.getUserID(), user.getUserName(), user.getUserEmail()))
                .collect(Collectors.toList());
    }


}
