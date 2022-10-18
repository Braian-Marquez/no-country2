package com.pixiesarg.back.domain.response;

import com.pixiesarg.back.domain.entity.AssetsEntity;
import com.pixiesarg.back.domain.entity.AvatarEntity;
import com.pixiesarg.back.domain.entity.EquipEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserProfileResponse {
    private String firstName;
    private String lastName;
    private String country;
    private AvatarEntity avatar;
    private List<AssetsEntity> assets;
    private Long money;
    private List<Long> idFavorite;
}
