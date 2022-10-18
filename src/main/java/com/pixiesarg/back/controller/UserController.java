package com.pixiesarg.back.controller;

import com.pixiesarg.back.domain.response.UserProfileResponse;
import com.pixiesarg.back.repository.UserRepository;
import com.pixiesarg.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

@CrossOrigin(origins = "*", methods= {GET, POST, PUT, DELETE})
@RestController
@RequestMapping("users")
public class UserController {

    private UserRepository userRepository;
    private UserService userService;

    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<UserProfileResponse> getUserId(@RequestParam Long id) {
        UserProfileResponse result = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


    @GetMapping("all")
    public ResponseEntity<?> readAllUsers() {
        return new ResponseEntity<>(userService.readAllUsers(), HttpStatus.OK);
    }
}