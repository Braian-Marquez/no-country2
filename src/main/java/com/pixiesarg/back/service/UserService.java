package com.pixiesarg.back.service;

import com.pixiesarg.back.domain.response.UserProfileResponse;

import java.util.List;

public interface UserService {
    UserProfileResponse getUserProfile(String name);

    List<UserProfileResponse> getAllUsers();

    UserProfileResponse getUserById(Long id);

    List<UserProfileResponse> readAllUsers();
}
