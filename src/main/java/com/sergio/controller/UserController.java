package com.sergio.controller;

import com.sergio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.transaction.Transactional;


@RestController
@Transactional
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }


    @GetMapping(value = "/{login}")
    public ResponseEntity<?> getById(@PathVariable String login) {
        return ResponseEntity.ok(userService.createOrGetUser(login));
    }
}


