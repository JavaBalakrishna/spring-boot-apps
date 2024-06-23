package com.code.validation.exception.service.impl;

import com.code.validation.exception.dto.UserRequest;
import com.code.validation.exception.entity.User;
import com.code.validation.exception.exception.UserNotFoundException;
import com.code.validation.exception.repo.UserRepository;
import com.code.validation.exception.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UerServiceImpl implements Userservice {

    @Autowired
    UserRepository repository;

    @Override
    public User saveUser(UserRequest userRequest) {
        User user=new User();
        user.setAge(userRequest.getAge());
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setMobile(userRequest.getMobile());
        user.setGender(userRequest.getGender());
        userRequest.setGender(userRequest.getGender());

        return repository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return repository.findAll();
    }

    @Override
    public User getUser(int userId)  {
       Optional<User> optional= repository.findById(userId);
       if(optional.isEmpty())
           throw new UserNotFoundException("user not found with id : "+userId);
        return repository.findById(userId).get();
    }
}
