package com.example.EmpSystem.controller;

import com.example.EmpSystem.dto.LoginDTO;
import com.example.EmpSystem.dto.LoginResponseDTO;
import com.example.EmpSystem.entity.User;
import com.example.EmpSystem.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {

        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody LoginDTO loginDTO) {

        return userService.loginUser(loginDTO);
    }
}
