package com.example.quotopiabackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id", nullable = false)
    private int adminID;

    @Column(name = "admin_name", nullable = false)
    private String adminName;

    @Column(name = "admin_email")
    private String adminEmail;

    @Column(name = "admin_password", nullable = false)
    private String adminPassword;

    public Admin(int adminID, String adminName, String adminEmail) {
        this.adminID = adminID;
        this.adminName = adminName;
        this.adminEmail = adminEmail;
    }
}
