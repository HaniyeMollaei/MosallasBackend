package com.haniyemollaei.mosallas.controller;

import com.haniyemollaei.mosallas.domain.User;
import com.haniyemollaei.mosallas.repository.UserRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "user-info/user-type")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<List<String>> getUserType() {
        List<User> userList = userRepository.findAll();
        List<String> userTypeList = new ArrayList<>();
        for (int i = 0 ; i < userList.size() ; i++) {
            userTypeList.add(userList.get(i).getUserType());
        }
        return ResponseEntity.ok(userTypeList);
    }
}
