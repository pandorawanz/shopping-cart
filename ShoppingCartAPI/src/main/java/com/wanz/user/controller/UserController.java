package com.wanz.user.controller;

import com.wanz.user.model.User;
import com.wanz.user.model.UserDao;
import com.wanz.user.view.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<GetUserResponse> getUser(@PathVariable int userId) {
        User user = userDao.getById(userId);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new GetUserResponse(user), HttpStatus.OK);
        }
    }

    @GetMapping("/users")
    public ResponseEntity<ListUserResponse> listUser() {
        List<User> userList = userDao.findAll();

        if (userList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new ListUserResponse(userList), HttpStatus.OK);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest createUserRequest) {
        User user = userDao.save(new User(createUserRequest.getName(), createUserRequest.getPassword()));
        return new ResponseEntity<>(new CreateUserResponse(user), HttpStatus.CREATED);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<UpdateUserResponse> updateUser(@RequestBody UpdateUserRequest updateUserRequest, @PathVariable int userId) {
        User user = userDao.getById(userId);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        user.setName(updateUserRequest.getName());
        user.setPassword(updateUserRequest.getPassword());
        userDao.save(user);

        return new ResponseEntity<>(new UpdateUserResponse(user),HttpStatus.OK);
    }
}
