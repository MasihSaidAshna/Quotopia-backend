package com.example.quotopiabackend.controller;

import com.example.quotopiabackend.dto.dtoUser.UserDTO;
import com.example.quotopiabackend.dto.dtoUser.UserPasswordDTO;
import com.example.quotopiabackend.model.User;
import com.example.quotopiabackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody UserDTO userDTO) {
        User savedUser = userService.saveUser(userDTO);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/save-with-password")
    public ResponseEntity<User> saveUserWithPassword(@RequestBody UserPasswordDTO userPasswordDTO) {
        User savedUser = userService.saveUserWithPassword(userPasswordDTO);
        return ResponseEntity.ok(savedUser);
    }

    @PutMapping("/update/{userID}")
    public ResponseEntity<User> updateUser(@PathVariable int userID, @RequestBody UserDTO userDTO) {
        User updatedUser = userService.updateUser(userID, userDTO);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUser() {
        List<UserDTO> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }


}
