package com.example.quotopiabackend.jwtsecurity.repository;


import com.example.quotopiabackend.jwtsecurity.model.Genre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    Page<Genre> findAll(Pageable pageable);
}
