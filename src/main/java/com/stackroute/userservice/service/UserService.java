package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.exceptions.UserAlreadyExistsException;

import java.util.List;

public interface UserService {

    public User SaveUser(User user)throws UserAlreadyExistsException;

    public List<User> getAllusers();
}
