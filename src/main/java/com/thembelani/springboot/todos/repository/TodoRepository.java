package com.thembelani.springboot.todos.repository;

import com.thembelani.springboot.todos.entity.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo,Long> {
}
