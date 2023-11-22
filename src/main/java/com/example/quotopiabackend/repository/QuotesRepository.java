package com.example.quotopiabackend.repository;

import com.example.quotopiabackend.entity.Quotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuotesRepository extends JpaRepository<Quotes, Integer> {
}
