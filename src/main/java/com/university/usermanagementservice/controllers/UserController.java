package com.university.usermanagementservice.controllers;

import com.university.usermanagementservice.dao.UserRepository;
import com.university.usermanagementservice.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v0")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public Mono<ResponseEntity<Map<String, Object>>> getAllUsers(){
        Map<String,Object> map = new HashMap<>();
        Map<Integer, User> users = userRepository.getAllUsers();

        map.put("code",200);
        map.put("message","success");
        map.put("data", users);
        return Mono.just(ResponseEntity.ok().body(map));
    }

    @GetMapping("/users/user/{userId}/roles")
    public Mono<ResponseEntity<Map<String, Object>>> getUserRoles(@PathVariable("userId") int userId) {
        Map<String, Object> map = new HashMap<>();

        var roles = userRepository.getRolesByUserId(userId);

        map.put("code", 200);
        map.put("message", "success");
        map.put("data", roles);

        return Mono.just(ResponseEntity.ok().body(map));
    }

    @GetMapping("/users/user/{userId}")
    public Mono<ResponseEntity<Map<String, Object>>> getUserById(@PathVariable("userId") int userId) {

        Map<String, Object> map = new HashMap<>();

        User user = userRepository.getUserById(userId);

        map.put("code", 200);
        map.put("message", "success");
        map.put("data", user);

        return Mono.just(ResponseEntity.ok().body(map));
    }


}
