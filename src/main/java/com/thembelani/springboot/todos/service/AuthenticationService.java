package com.thembelani.springboot.todos.service;

import com.thembelani.springboot.todos.request.AuthenticationRequest;
import com.thembelani.springboot.todos.request.RegisterRequest;
import com.thembelani.springboot.todos.response.AuthenticationResponse;

public interface AuthenticationService {
    void register(RegisterRequest input) throws Exception;

    AuthenticationResponse login(AuthenticationRequest request);
}
