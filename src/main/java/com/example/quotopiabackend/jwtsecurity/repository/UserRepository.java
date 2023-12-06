package com.example.quotopiabackend.jwtsecurity.repository;

import com.example.quotopiabackend.jwtsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserID(Integer ID);

    List<User> findByUserName(String userName);
    //List<User> findUserByPasswordContains(String passwordPart);
}
