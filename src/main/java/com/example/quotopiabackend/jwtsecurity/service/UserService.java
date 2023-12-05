package com.example.quotopiabackend.jwtsecurity.service;

import com.example.quotopiabackend.jwtsecurity.config.SecurityConfiguration;
import com.example.quotopiabackend.jwtsecurity.model.User;
import com.example.quotopiabackend.jwtsecurity.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Set<User> findAll() {
        return new HashSet<>(userRepository.findAll());
    }

    @Override
    public User save(User user) {
//        if(user.getPassword() == null) {
        PasswordEncoder pw = SecurityConfiguration.passwordEncoder();
        user.setUserPassword(pw.encode(user.getUserPassword()));
//        }
        return userRepository.save(user);
    }

    @Override
    public void delete(User object) {
        userRepository.delete(object);
    }

    @Override
    public void deleteById(Integer intU) {

    }

    @Override
    public Optional<User> findById(Integer intU) {
        return userRepository.findById(intU);
    }

    @Override
    public List<User> findByName(String name) {
        System.out.println("Userservice called findByName with argument: " + name);
        return userRepository.findByUserName(name);
    }

}