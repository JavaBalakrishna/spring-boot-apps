package com.code.validation.exception.service;

import com.code.validation.exception.dto.UserRequest;
import com.code.validation.exception.entity.User;

import java.util.List;

public interface  Userservice {
    public User saveUser(UserRequest userRequest);
    public List<User> getAllUser();
    public User getUser(int userId);
}
