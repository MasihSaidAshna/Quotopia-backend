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
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private int adminID;

    @Column(name = "admin_name")
    @NotBlank(message = "Admin name is required")
    private String adminName;

    @Column(name = "admin_email")
    @Email(message = "Please provide a valid email address")
    private String adminEmail;

    @Column(name = "admin_password")
    @NotBlank(message = "Password is required")
    @JsonIgnore
    private String adminPassword;

    public Admin(int adminID, String adminName, String adminEmail) {
        this.adminID = adminID;
        this.adminName = adminName;
        this.adminEmail = adminEmail;
    }
}
