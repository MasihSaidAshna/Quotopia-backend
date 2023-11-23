package com.example.quotopiabackend.repository;

import com.example.quotopiabackend.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuotesRepository extends JpaRepository<Quote, Integer> {
}
