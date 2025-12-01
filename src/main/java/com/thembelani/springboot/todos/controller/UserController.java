package com.thembelani.springboot.todos.controller;

import com.thembelani.springboot.todos.entity.User;
import com.thembelani.springboot.todos.response.UserResponse;
import com.thembelani.springboot.todos.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "User REST API Endpoints",description = "Operations related to info about current user")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/info")
    public UserResponse getUserInfo(){
        return userService.getUserInfo();
    }
}
