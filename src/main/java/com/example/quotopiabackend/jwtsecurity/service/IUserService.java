package com.example.quotopiabackend.jwtsecurity.service;


import com.example.quotopiabackend.jwtsecurity.model.User;

import java.util.List;

public interface IUserService extends ICrudService<User,Integer>{
    User findByName(String name);

}
