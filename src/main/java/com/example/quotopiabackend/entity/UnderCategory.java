package com.example.quotopiabackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "under_category")
public class UnderCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "under_category_id")
    private int underCategoryId;

    @Column(name = "under_category_name")
    private String underCategoryName;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;



}
