package com.pixiesarg.back.mapper;

import com.pixiesarg.back.domain.entity.UserEntity;
import com.pixiesarg.back.domain.response.UserProfileResponse;
import com.pixiesarg.back.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserProfileMapper {

    public UserProfileResponse userEntityToResponse(UserEntity entity) {
        UserProfileResponse userProfile = new UserProfileResponse();
        userProfile.setFirstName(entity.getFirstName());
        userProfile.setCountry(entity.getCountry());
        userProfile.setAvatar(entity.getAvatar());
        userProfile.setIdFavorite(entity.getIdFavorite());
        return userProfile;
    }


}
