package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.exceptions.UserAlreadyExistsException;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User SaveUser(User user)throws UserAlreadyExistsException {

        if(userRepository.existsById(user.getId())){
            throw new UserAlreadyExistsException("User already exists");
        }
        User savedUser=userRepository.save(user);
        if(savedUser==null){
            throw new UserAlreadyExistsException("User already exists");
        }
        return savedUser;
    }

    @Override
    public List<User> getAllusers() {
        return userRepository.findAll();
    }


    }
