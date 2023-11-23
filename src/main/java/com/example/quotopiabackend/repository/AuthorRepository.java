package com.example.quotopiabackend.repository;


import com.example.quotopiabackend.model.Authur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Authur, Integer> {
}
