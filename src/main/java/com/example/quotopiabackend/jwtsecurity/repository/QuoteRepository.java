package com.example.quotopiabackend.jwtsecurity.repository;

import com.example.quotopiabackend.jwtsecurity.model.Quote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Integer> {
    List<Quote> findByGenre(String genre);
    Page<Quote> findAll(Pageable pageable);
}