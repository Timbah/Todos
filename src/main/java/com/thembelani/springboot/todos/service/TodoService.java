package com.thembelani.springboot.todos.service;

import com.thembelani.springboot.todos.request.TodoRequest;
import com.thembelani.springboot.todos.response.TodoResponse;

import java.util.List;

public interface TodoService {
    List<TodoResponse> getAllTodos();
    TodoResponse createTodo(TodoRequest todoRequest);
    TodoResponse toggleTodoCompletion(long id);
    void deleteTodo(long id);
}
