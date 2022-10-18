package com.pixiesarg.back.mapper;


import com.pixiesarg.back.domain.entity.UserEntity;
import com.pixiesarg.back.domain.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponse entity2DTO(UserEntity entity) {
        UserResponse dto = new UserResponse();
        dto.setFirstName(entity.getUsername());
        dto.setLastName(entity.getLastName());
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        return dto;
    }

}
