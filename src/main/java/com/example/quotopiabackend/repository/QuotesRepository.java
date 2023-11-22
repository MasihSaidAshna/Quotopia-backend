package com.example.quotopiabackend.repository;

import dat3.server_to_server.entity.Quotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuotesRepository extends JpaRepository<Quotes, Integer> {
}
