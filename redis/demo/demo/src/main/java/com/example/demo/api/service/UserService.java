package com.example.demo.api.service;


import com.example.demo.db.entity.User;

import java.util.List;


public interface UserService {
    public void insertUser(User user);
    public User searchUser(int id);
    public List<User> searchAll();
    public void deleteUser(int id);
}
