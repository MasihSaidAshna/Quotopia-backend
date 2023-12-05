package com.example.quotopiabackend.jwtsecurity.config;

import com.example.quotopiabackend.jwtsecurity.model.User;
import com.example.quotopiabackend.jwtsecurity.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public CommandLineRunner demoData(UserRepository userRepository) {
        return args -> {
            User user = new User("Admin1", "admin1@example.com", false, "password1");
            User user1 = new User("Admin2", "admin2@example.com",false, "password2");

            userRepository.save(user);
            userRepository.save(user1);

        };


    }
}
