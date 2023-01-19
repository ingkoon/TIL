package com.example.demo.api.service;


import com.example.demo.db.entity.User;
import com.example.demo.db.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserJpaRepository userJpaRepository;

    @Transactional
    @Override
    public void insertUser(User user) {
        userJpaRepository.save(user);
    }

    @Override
    public User searchUser(int id) {
        Optional<User> user = userJpaRepository.findById(id);
        return user.get();
    }

    @Override
    public List<User> searchAll() {
        List<User> users = userJpaRepository.findAll();
        return users;
    }

    @Override
    @Transactional
    public void deleteUser(int id){
        userJpaRepository.deleteById(id);
    }


}
