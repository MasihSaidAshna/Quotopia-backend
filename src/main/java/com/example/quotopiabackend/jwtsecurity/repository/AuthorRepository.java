package com.example.quotopiabackend.jwtsecurity.repository;

import com.example.quotopiabackend.jwtsecurity.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
