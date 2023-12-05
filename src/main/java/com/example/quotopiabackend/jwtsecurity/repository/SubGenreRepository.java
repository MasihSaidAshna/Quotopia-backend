package com.example.quotopiabackend.jwtsecurity.repository;


import com.example.quotopiabackend.jwtsecurity.model.SubGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubGenreRepository extends JpaRepository<SubGenre, Integer> {
}
