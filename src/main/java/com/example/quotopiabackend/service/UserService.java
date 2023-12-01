package com.example.quotopiabackend.service;

import com.example.quotopiabackend.dto.dtoUser.UserConverter;
import com.example.quotopiabackend.dto.dtoUser.UserDTO;
import com.example.quotopiabackend.dto.dtoUser.UserPasswordConverter;
import com.example.quotopiabackend.dto.dtoUser.UserPasswordDTO;
import com.example.quotopiabackend.model.User;
import com.example.quotopiabackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPasswordConverter userPasswordConverter;

    @Autowired
    private UserConverter userConverter;

    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userRepository.findAll().stream()
                .map(userConverter::toUserDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    public ResponseEntity<UserDTO> getUserById(int userID) {
        Optional<User> user = userRepository.findById(userID);
        return user.map(value -> new ResponseEntity<>(userConverter.toUserDTO(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<UserDTO> saveUserWithPassword(UserPasswordDTO userPasswordDTO) {
        User newUser = userPasswordConverter.toUserPasswordModel(userPasswordDTO);
        User savedUser = userRepository.save(newUser);
        return new ResponseEntity<>(userConverter.toUserDTO(savedUser), HttpStatus.CREATED);
    }

    public ResponseEntity<UserDTO> updateUser(int userID, UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findById(userID);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setUserName(userDTO.userName());
            existingUser.setUserEmail(userDTO.userEmail());
            userRepository.save(existingUser);
            return new ResponseEntity<>(userConverter.toUserDTO(existingUser), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Void> deleteUser(int userID) {
        if (userRepository.existsById(userID)) {
            userRepository.deleteById(userID);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void changeUserRole(int userId, boolean isAdmin) {
       Optional<User> optionalUser = userRepository.findById(userId);

       if (optionalUser.isPresent()){
           User user = optionalUser.get();
           user.setAdmin(isAdmin);
           userRepository.save(user);
       }else {
           throw new RuntimeException("User not found");
       }
    }

}