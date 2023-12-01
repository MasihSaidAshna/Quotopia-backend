package com.example.quotopiabackend.controller;

import com.example.quotopiabackend.dto.dtoUser.UserDTO;
import com.example.quotopiabackend.dto.dtoUser.UserPasswordDTO;
import com.example.quotopiabackend.model.User;
import com.example.quotopiabackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/saveWithPassword")
    public ResponseEntity<UserDTO> saveUserWithPassword(@RequestBody UserPasswordDTO userPasswordDTO) {
        return userService.saveUserWithPassword(userPasswordDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

}
