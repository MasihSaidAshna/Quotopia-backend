package com.example.quotopiabackend.config;

import com.example.quotopiabackend.model.User;
import com.example.quotopiabackend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminConfig {

    @Bean
    public CommandLineRunner demoData(UserRepository userRepository) {
        return args -> {
            // Add some demo data for Admin
            User user = new User("Admin1", "admin1@example.com", false, "password1");
            User user1 = new User("Admin2", "admin2@example.com",false, "password2");

            userRepository.save(user);
            userRepository.save(user1);

            // You can add more admin entities as needed
        };


    }
}
