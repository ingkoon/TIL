package com.example.demo.api.controller;


import com.example.demo.api.service.UserService;
import com.example.demo.db.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("users")
@RestController
@Tag(name="[@User] 샘플 컨트롤러")
public class UserController {
    private final UserService userService;

    private final StringRedisTemplate redisTemplate;
    @PostMapping
    public ResponseEntity<String> CreateUser(@RequestBody User user){
        userService.insertUser(user);
        redisTemplate.opsForSet().add(user.getUserAccount(), user.getUserName());
//        log.debug("userId is = " + user.getId()+"");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("회원 생성 성공");
    }

    @Operation(summary = "get user list api summary", description = "[@Operation] get user list api")
    @GetMapping
    public  ResponseEntity<?> searchUserList(){
        log.debug("====================");
        List<User> list = userService.searchAll();

        if(list.size() == 0){
            return ResponseEntity
                .status(HttpStatus.OK).body("비어있네여");
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(list);
    }

    @Operation(summary = "get user api summary", description = "[@Operation] get user list api")
    @GetMapping(value = "/{userId}")
    public  ResponseEntity<User> searchUser(@PathVariable("userId") final String userId){
        int id = Integer.parseInt(userId);
        log.info("============== 컨트롤러 진입 ================");
        User user = userService.searchUser(id);
        Set<String> members = redisTemplate.opsForSet().members(user.getUserAccount());
        log.info(user.getUserAccount());
        log.info( "================================" + Arrays.toString(members.toArray()) + "====================================");
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @DeleteMapping(value = "/{userId}")
    ResponseEntity<String> deleteUSer(@PathVariable("userId") final int userId){
        log.info("============== 컨트롤러 진입 ================");
        userService.deleteUser(userId);
        log.info("========================================");
        return ResponseEntity.status(HttpStatus.OK).body("성공적으로 삭제되었습니다");
    }
}
