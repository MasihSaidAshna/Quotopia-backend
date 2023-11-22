package com.example.quotopiabackend.repository;

import dat3.server_to_server.entity.UnderCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnderCategoryRepository extends JpaRepository<UnderCategory, Integer> {
}
