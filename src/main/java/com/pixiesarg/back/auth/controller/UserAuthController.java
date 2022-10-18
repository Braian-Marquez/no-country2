package com.pixiesarg.back.auth.controller;


import com.pixiesarg.back.auth.service.UserDetailsCustomService;
import com.pixiesarg.back.domain.request.AuthenticationRequest;
import com.pixiesarg.back.domain.request.UserRequest;
import com.pixiesarg.back.domain.response.AuthenticationResponse;
import com.pixiesarg.back.domain.response.UserProfileResponse;
import com.pixiesarg.back.domain.response.UserResponse;
import com.pixiesarg.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

@CrossOrigin(origins = "*", methods= {GET, POST, PUT, DELETE})
@RestController
@RequestMapping("/auth")
public class UserAuthController {

    @Autowired
    private UserDetailsCustomService userDetailsService;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/register")
    public ResponseEntity<UserResponse> signup(@Valid @RequestBody UserRequest user) throws Exception {
        UserResponse result = this.userDetailsService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);

    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody @Valid AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(userDetailsService.login(authenticationRequest));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile(Principal request) {
        UserProfileResponse dto = userService.getUserProfile(request.getName());
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("id_user");
        return "redirect:/";

    }
}
