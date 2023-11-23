package com.example.quotopiabackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

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

    @Column(name = "user_name")
    @NotBlank(message = "User name is required")
    private String userName;

    @Column(name = "user_email")
    @Email(message = "Please provide a valid email address")
    private String userEmail;

    @Column(name = "user_password")
    @NotBlank(message = "Password is required")
    @JsonIgnore
    private String userPassword;

    public User(int userID, String userName, String userEmail) {
        this.userID = userID;
        this.userName = userName;
        this.userEmail = userEmail;
    }
}
