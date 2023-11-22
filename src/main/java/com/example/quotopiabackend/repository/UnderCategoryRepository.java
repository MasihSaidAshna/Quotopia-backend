package com.example.quotopiabackend.repository;


import com.example.quotopiabackend.entity.UnderCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnderCategoryRepository extends JpaRepository<UnderCategory, Integer> {
}
