package com.code.validation.exception.controller;

import com.code.validation.exception.dto.UserRequest;
import com.code.validation.exception.entity.User;
import com.code.validation.exception.exception.UserNotFoundException;
import com.code.validation.exception.service.Userservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    Userservice userservice;

    @PostMapping("/signup")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest){
        User user= userservice.saveUser(userRequest);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<User>> getAllUsers(){
        return  ResponseEntity.ok(userservice.getAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int userId) {
        User user=userservice.getUser(userId);
        return ResponseEntity.ok(userservice.getUser(userId));
    }
}
