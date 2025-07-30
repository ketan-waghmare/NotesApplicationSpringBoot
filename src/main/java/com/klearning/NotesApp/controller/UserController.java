package com.klearning.NotesApp.controller;

import com.klearning.NotesApp.models.User;
import com.klearning.NotesApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public void registerUser(@RequestBody  User user) {
        userService.createUser(user);
    }

    @PostMapping("/login")
    public void loginUser(@RequestBody User user) {
        //TODO: Implement login api here
    }
}
