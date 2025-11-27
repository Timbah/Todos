package com.thembelani.springboot.todos.request;

public interface AuthenticationService {
    void register(RegisterRequest input) throws Exception;
}
