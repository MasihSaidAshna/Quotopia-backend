package com.example.quotopiabackend.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "quotes")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quote_id")
    private int quoteID;

    @Column(name = "quote_text")
    private String quoteText;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Authur author;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;


}