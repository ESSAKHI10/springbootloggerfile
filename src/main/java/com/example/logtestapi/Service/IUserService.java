package com.example.logtestapi.Service;

import java.util.List;

import com.example.logtestapi.Entity.User;

public interface IUserService {
    User createUser(User user);

    List<User> findAllUser();
}
