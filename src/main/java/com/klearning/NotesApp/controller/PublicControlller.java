package com.klearning.NotesApp.controller;

import com.klearning.NotesApp.models.User;
import com.klearning.NotesApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicControlller {

    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @GetMapping("/health-check")
    public String healthCheck() {
        return "Ok";
    }

}
