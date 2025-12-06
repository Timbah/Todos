package com.thembelani.springboot.todos.service;

import com.thembelani.springboot.todos.request.PasswordUpdateRequest;
import com.thembelani.springboot.todos.response.UserResponse;

public interface UserService {

    UserResponse getUserInfo();
    void deleteUser();
    void updatePassword(PasswordUpdateRequest passwordUpdateRequest);
}
