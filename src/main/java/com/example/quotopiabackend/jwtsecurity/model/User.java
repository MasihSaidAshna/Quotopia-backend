package com.example.quotopiabackend.jwtsecurity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userID;

    @Column(name = "user_name", nullable = false)
    private String username;


    @Column(name = "user_password", nullable = false)
    private String userPassword;


    @Column(name = "local_time", columnDefinition = "TIME")
    private LocalTime localTime = LocalTime.of(6,43,12);

    public User(String username, String userPassword) {
        this.username = username;
        this.userPassword = userPassword;
    }
}
