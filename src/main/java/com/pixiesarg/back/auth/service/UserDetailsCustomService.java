package com.pixiesarg.back.auth.service;

import com.pixiesarg.back.auth.jwt.JwtUtils;
import com.pixiesarg.back.auth.security.RoleType;
import com.pixiesarg.back.domain.entity.AvatarEntity;
import com.pixiesarg.back.domain.entity.UserEntity;
import com.pixiesarg.back.domain.request.AuthenticationRequest;
import com.pixiesarg.back.domain.request.UserRequest;
import com.pixiesarg.back.domain.response.AuthenticationResponse;
import com.pixiesarg.back.domain.response.UserResponse;
import com.pixiesarg.back.mapper.UserMapper;
import com.pixiesarg.back.repository.AvatarRepository;
import com.pixiesarg.back.repository.RoleRepository;
import com.pixiesarg.back.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import javax.sql.rowset.serial.SerialBlob;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.util.Base64;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class UserDetailsCustomService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private JwtUtils jwtUtil;
    @Autowired
    private AvatarRepository avatarRepository;


    @Autowired
    @Lazy
    private AuthenticationManager authenticationManager;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(userName);
        if (userEntity == null) {
            throw new UsernameNotFoundException("Username or password not found");
        }
        return new User(userEntity.getUsername(), userEntity.getPassword(), userEntity.getAuthorities());
    }

    public UserResponse save(UserRequest userRequest) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserEntity userEntity = new UserEntity();
        AvatarEntity avatar = new AvatarEntity();
        userEntity.setFirstName(userRequest.getFirstName());
        userEntity.setLastName(userRequest.getLastName());
        userEntity.setEmail(userRequest.getEmail());
        userEntity.setUsername(userRequest.getEmail());
        userEntity.setCountry(userRequest.getCountry());
        userEntity.setMoney(1000L);
        avatar.setName("avatar");
        avatar.setImage("https://i.imgur.com/tpviGnP.png");
        avatar.setId(userEntity.getId());
        avatarRepository.save(avatar);
        userEntity.setLikes(0L);
        userEntity.setAvatar(avatar);
        userEntity.setRoles(List.of(roleRepository.findByName(RoleType.ADMIN.getFullRoleName())));
        userEntity.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        UserResponse result = userMapper.entity2DTO(userRepository.save(userEntity));
        result.setToken(jwtUtil.generateToken(userEntity));

        return result;

    }


    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
        UserEntity user = userRepository.findByEmail(authenticationRequest.getUsername());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()));

        return new AuthenticationResponse(user.getUsername(), jwtUtil.generateToken(user),user.getId());
    }


}
