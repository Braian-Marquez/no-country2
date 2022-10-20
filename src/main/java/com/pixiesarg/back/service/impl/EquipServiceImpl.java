package com.pixiesarg.back.service.impl;


import com.pixiesarg.back.domain.entity.AssetsEntity;
import com.pixiesarg.back.domain.entity.AvatarEntity;
import com.pixiesarg.back.domain.entity.EquipEntity;
import com.pixiesarg.back.exception.NotFoundException;
import com.pixiesarg.back.repository.*;
import com.pixiesarg.back.service.EquipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class EquipServiceImpl implements EquipService {


    private EquipRepository equipRepository;
    private AssetsRepository assetsRepository;
    private AvatarRepository avatarRepository;

    @Autowired
    public EquipServiceImpl(EquipRepository equipRepository, AssetsRepository assetsRepository, AvatarRepository avatarRepository) {
        this.equipRepository = equipRepository;
        this.assetsRepository = assetsRepository;
        this.avatarRepository = avatarRepository;
    }

    @Override
    public void equip(Long id, Long idAvatar) {
        EquipEntity equip = new EquipEntity();
        AssetsEntity assets = getAssets(id);
        AvatarEntity avatar = getAvatar(idAvatar);
        equip.setId(assets.getId());
        equip.setName(assets.getName());
        equip.setImage(assets.getImage());
        assets.setIsAvailable(false);
        avatar.getEquip().add(equip);
        equipRepository.save(equip);
        avatarRepository.save(avatar);
    }

    private AssetsEntity getAssets(Long id) {
        Optional<AssetsEntity> assets = assetsRepository.findById(id);
        if (assets.isEmpty()) {
            throw new NotFoundException("Post not found.");
        }
        return assets.get();
    }

    private AvatarEntity getAvatar(Long id) {
        Optional<AvatarEntity> avatar = avatarRepository.findById(id);
        if (avatar.isEmpty()) {
            throw new NotFoundException("Post not found.");
        }
        return avatar.get();
    }

}
