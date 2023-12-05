package com.example.quotopiabackend.jwtsecurity.model;

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
@Table(name = "sub_genre")
public class SubGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_genre_id")
    private int subGenreID;

    @Column(name = "sub_genre_name")
    private String subGenreName;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

}
