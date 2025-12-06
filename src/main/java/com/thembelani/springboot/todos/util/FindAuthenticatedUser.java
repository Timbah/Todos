package com.thembelani.springboot.todos.util;

import com.thembelani.springboot.todos.entity.User;

public interface FindAuthenticatedUser {
    User getAuthenticatedUser();
}
