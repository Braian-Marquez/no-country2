package com.pixiesarg.back.service.impl;

import com.pixiesarg.back.domain.entity.UserEntity;
import com.pixiesarg.back.domain.response.UserProfileResponse;
import com.pixiesarg.back.exception.NotFoundException;
import com.pixiesarg.back.mapper.UserProfileMapper;
import com.pixiesarg.back.repository.UserRepository;
import com.pixiesarg.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final String USER_NOT_FOUND_MESSAGE = "User not found.";
    private UserProfileMapper userProfileMapper;
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserProfileMapper userProfileMapper, UserRepository userRepository) {
        this.userProfileMapper = userProfileMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserProfileResponse getUserProfile(String name) {
        return userProfileMapper.userEntityToResponse(getUser(name));
    }

    @Override
    public List<UserProfileResponse> getAllUsers() {
        List<UserEntity> userEntityList = userRepository.findAll();
        List<UserProfileResponse> userProfileResponseList = new ArrayList<>();
        for (UserEntity user : userEntityList) {
            userProfileResponseList.add(userProfileMapper.userEntityToResponse(user));
        }
        return userProfileResponseList;
    }

    @Override
    public UserProfileResponse getUserById(Long id) {
        UserEntity user = getUserId(id);
        UserProfileResponse response = new UserProfileResponse();
        response.setCountry(user.getCountry());
        response.setAvatar(user.getAvatar());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());
        response.setId(user.getId());
        response.setAssets(user.getInventory());
        response.setMoney(user.getMoney());
        response.setIdFavorite(user.getIdFavorite());
        return response;
    }


    private UserEntity getUser(String username) {
        UserEntity user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException(USER_NOT_FOUND_MESSAGE);
        }
        return user;
    }

    private UserEntity getUserId(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new NotFoundException("Post not found.");
        }
        return user.get();
    }

    @Override
    public List<UserProfileResponse> readAllUsers() {

        List<UserEntity> userEntityList = userRepository.findAll();
        List<UserProfileResponse> userProfileDTOList = new ArrayList<>();

        for (UserEntity user : userEntityList) {
            userProfileDTOList.add(userProfileMapper.userEntityToResponse(user));
        }

        return userProfileDTOList;
    }
}
