package com.example.quotopiabackend.entity;


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
public class Quotes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quotes_id")
    private int quotesId;

    @Column(name = "quote_text")
    private String quoteText;

    @ManyToOne
    @JoinColumn(name = "author")
    private Authur author;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}
