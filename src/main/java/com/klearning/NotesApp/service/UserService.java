package com.klearning.NotesApp.service;

import com.klearning.NotesApp.models.User;
import com.klearning.NotesApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final PasswordEncoder passwordEncoder =new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }


    public void loginUser(User user) {
        //TODO Implement login api here
    }
}
