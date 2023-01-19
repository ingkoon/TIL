package com.example.demo.user.repository;

import com.example.demo.db.entity.User;
import com.example.demo.db.repository.UserJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserJpaRepository userJpaRepository;
    @Autowired(required = false)
    private StringRedisTemplate stringRedisTemplate;

    @Test
    @DisplayName(value = "유저 생성 API")
    void insertTest(){
        User user = User.builder()
                .department("개발")
                .userName("홍길동")
                .userPassword("cucumber52")
                .position("대리")
                .userAccount("honggildong")
                .build();
        userJpaRepository.save(user);
        int id = user.getId();
        User findUser = userJpaRepository.findById(id).get();
        Assertions.assertEquals(user, findUser);

        stringRedisTemplate.opsForSet().add(user.getUserAccount(), user.getUserName());
        System.out.println(stringRedisTemplate.opsForSet().getOperations());

    }

}
