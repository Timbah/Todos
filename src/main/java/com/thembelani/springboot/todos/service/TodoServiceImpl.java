package com.thembelani.springboot.todos.service;

import com.thembelani.springboot.todos.entity.Todo;
import com.thembelani.springboot.todos.entity.User;
import com.thembelani.springboot.todos.repository.TodoRepository;
import com.thembelani.springboot.todos.request.TodoRequest;
import com.thembelani.springboot.todos.response.TodoResponse;
import com.thembelani.springboot.todos.util.FindAuthenticatedUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;
    private final FindAuthenticatedUser findAuthenticatedUser;

    public TodoServiceImpl(TodoRepository todoRepository, FindAuthenticatedUser findAuthenticatedUser) {
        this.todoRepository = todoRepository;
        this.findAuthenticatedUser = findAuthenticatedUser;
    }

    @Override
    @Transactional
    public TodoResponse createTodo(TodoRequest todoRequest) {

        User currentUser = findAuthenticatedUser.getAuthenticatedUser();

        Todo todo = new Todo(
                todoRequest.getTitle(),
                todoRequest.getDescription(),
                todoRequest.getPriority(),
                false,
                currentUser
        );

        Todo savedTodo = todoRepository.save(todo);

        TodoResponse todoResponse = new TodoResponse(
                savedTodo.getId(),
                savedTodo.getTitle(),
                savedTodo.getDescription(),
                savedTodo.getPriority(),
                savedTodo.isComplete()
                );

        return todoResponse;
    }
}
