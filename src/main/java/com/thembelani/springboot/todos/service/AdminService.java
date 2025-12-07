package com.thembelani.springboot.todos.service;

import com.thembelani.springboot.todos.response.UserResponse;

import java.util.List;

public interface AdminService {
    List<UserResponse> getAllUsers();
    UserResponse promoteToAdmin(long userid);
}
