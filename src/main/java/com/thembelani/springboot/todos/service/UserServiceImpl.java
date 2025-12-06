package com.thembelani.springboot.todos.service;


import com.thembelani.springboot.todos.entity.Authority;
import com.thembelani.springboot.todos.entity.User;
import com.thembelani.springboot.todos.repository.UserRepository;
import com.thembelani.springboot.todos.response.UserResponse;
import com.thembelani.springboot.todos.util.FindAuthenticatedUser;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final FindAuthenticatedUser findAuthenticatedUser;

    public UserServiceImpl(UserRepository userRepository, FindAuthenticatedUser findAuthenticatedUser) {
        this.userRepository = userRepository;
        this.findAuthenticatedUser = findAuthenticatedUser;
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse getUserInfo() {


        User user =  findAuthenticatedUser.getAuthenticatedUser();

        return new UserResponse(
                user.getId(),
                user.getFirstName() + " " + user.getLastName(),
                user.getEmail(),
                user.getAuthorities().stream().map(auth -> (Authority) auth).toList()
        );
    }

    @Override
    public void deleteUser() {

        User user =  findAuthenticatedUser.getAuthenticatedUser();

        //Check to make sure that this is not the last admin in the database
        if(isLastAdmin(user)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,"Admin cannot delete itself");
        }

        userRepository.delete(user);
    }

    private boolean isLastAdmin(User user){
        boolean isAdmin = user.getAuthorities().stream()
                .anyMatch(authority -> "ROLE_ADMIN".equals(authority.getAuthority()));

        if(isAdmin){
            //Check if this is not the last admin
            long adminCount = userRepository.countAdminUsers();
            return adminCount <=1;
        }
        return false;
    }
}
