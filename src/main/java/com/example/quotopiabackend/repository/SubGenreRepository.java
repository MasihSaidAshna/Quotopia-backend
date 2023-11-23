package com.example.quotopiabackend.repository;


import com.example.quotopiabackend.model.SubGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubGenreRepository extends JpaRepository<SubGenre, Integer> {
}
