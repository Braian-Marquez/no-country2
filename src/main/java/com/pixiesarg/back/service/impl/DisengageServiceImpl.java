package com.pixiesarg.back.service.impl;

import com.pixiesarg.back.domain.entity.AssetsEntity;
import com.pixiesarg.back.domain.entity.EquipEntity;
import com.pixiesarg.back.exception.NotFoundException;
import com.pixiesarg.back.repository.*;
import com.pixiesarg.back.service.DisengageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class DisengageServiceImpl implements DisengageService {


    private EquipRepository equipRepository;
    private AssetsRepository assetsRepository;
    private AvatarRepository avatarRepository;

    @Autowired
    public DisengageServiceImpl(EquipRepository equipRepository, AssetsRepository assetsRepository, AvatarRepository avatarRepository) {
        this.equipRepository = equipRepository;
        this.assetsRepository = assetsRepository;
        this.avatarRepository = avatarRepository;
    }


    @Override
    public void disengage(Long id) {
        AssetsEntity assets = new AssetsEntity();
        EquipEntity equip = getEquip(id);
        assets.setName(equip.getName());
        assets.setImage(equip.getImage());
        assets.setIsAvailable(true);
        assetsRepository.save(assets);
        equipRepository.delete(equip);

    }

    private EquipEntity getEquip(Long id) {
        Optional<EquipEntity> avatar = equipRepository.findById(id);
        if (avatar.isEmpty()) {
            throw new NotFoundException("Post not found.");
        }
        return avatar.get();
    }

}
