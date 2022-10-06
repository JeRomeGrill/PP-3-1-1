package com.jerome.springboot.pp311.web.service;

import com.jerome.springboot.pp311.web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    void changeUser(User user);

    void removeUser(Long id);

    User findById(Long id);
}
