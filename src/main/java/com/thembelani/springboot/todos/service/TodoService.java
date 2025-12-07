package com.thembelani.springboot.todos.service;

import com.thembelani.springboot.todos.request.TodoRequest;
import com.thembelani.springboot.todos.response.TodoResponse;

public interface TodoService {
    TodoResponse createTodo(TodoRequest todoRequest);
}
