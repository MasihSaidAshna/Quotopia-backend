package com.example.quotopiabackend.jwtsecurity.config;

import com.example.quotopiabackend.jwtsecurity.model.User;
import com.example.quotopiabackend.jwtsecurity.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final IUserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DataLoader(IUserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Add a default admin user for testing
        String adminUsername = "admin";
        if (userService.findByName(adminUsername) == null) {
            User defaultAdmin = new User();
            defaultAdmin.setUsername(adminUsername);
            defaultAdmin.setUserPassword(passwordEncoder.encode("adminPassword"));

            userService.save(defaultAdmin);
        }
    }
}
