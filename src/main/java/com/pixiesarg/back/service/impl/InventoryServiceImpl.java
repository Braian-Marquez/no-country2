package com.pixiesarg.back.service.impl;

import com.pixiesarg.back.domain.assets.*;
import com.pixiesarg.back.domain.entity.AssetsEntity;
import com.pixiesarg.back.domain.entity.UserEntity;
import com.pixiesarg.back.exception.NotFoundException;
import com.pixiesarg.back.mapper.InventoryMapper;
import com.pixiesarg.back.repository.*;
import com.pixiesarg.back.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class InventoryServiceImpl implements InventoryService {

    private InventoryMapper inventoryMapper;
    private AssetsRepository assetsRepository;
    private StoreRepository storeRepository;
    private BodyRepository bodyRepository;
    private HairRepository hairRepository;
    private HandRepository handRepository;
    private HeadRepository headRepository;
    private LegsRepository legsRepository;
    private PetsRepository petsRepository;
    private UserRepository userRepository;

    @Autowired
    public InventoryServiceImpl(InventoryMapper inventoryMapper, AssetsRepository assetsRepository, StoreRepository storeRepository, BodyRepository bodyRepository, HairRepository hairRepository, HandRepository handRepository, HeadRepository headRepository, LegsRepository legsRepository, PetsRepository petsRepository, UserRepository userRepository) {
        this.inventoryMapper = inventoryMapper;
        this.assetsRepository = assetsRepository;
        this.storeRepository = storeRepository;
        this.bodyRepository = bodyRepository;
        this.hairRepository = hairRepository;
        this.handRepository = handRepository;
        this.headRepository = headRepository;
        this.legsRepository = legsRepository;
        this.petsRepository = petsRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void buyBody(Long idBody, Long idUser) {
        AssetsEntity assets = new AssetsEntity();
        BodyAssets bodyAssets = getBody(idBody);
        UserEntity userEntity = getUser(idUser);

        if (userEntity.getMoney() < bodyAssets.getPrice()) {
            throw new NotFoundException("insufficient money");
        } else {
            userEntity.setMoney(userEntity.getMoney() - bodyAssets.getPrice());
        }
        assets.setName(bodyAssets.getName());
        assets.setImage(bodyAssets.getImage());
        bodyAssets.setIsAvailable(false);
        assetsRepository.save(assets);
        userEntity.getInventory().add(assets);
        userRepository.save(userEntity);
    }

    @Override
    public void buyHair(Long idHair, Long idUser) {
        AssetsEntity assets = new AssetsEntity();
        Hair hair = getHair(idHair);
        UserEntity userEntity = getUser(idUser);

        if (userEntity.getMoney() < hair.getPrice()) {
            throw new NotFoundException("insufficient money");
        } else {
            userEntity.setMoney(userEntity.getMoney() - hair.getPrice());
        }
        assets.setName(hair.getName());
        assets.setImage(hair.getImage());
        hair.setIsAvailable(false);
        assetsRepository.save(assets);
        userEntity.getInventory().add(assets);
        userRepository.save(userEntity);
    }

    @Override
    public void buyHand(Long idHand, Long idUser) {
        AssetsEntity assets = new AssetsEntity();
        Hand hand = getHand(idHand);
        UserEntity userEntity = getUser(idUser);

        if (userEntity.getMoney() < hand.getPrice()) {
            throw new NotFoundException("insufficient money");
        } else {
            userEntity.setMoney(userEntity.getMoney() - hand.getPrice());
        }
        assets.setName(hand.getName());
        assets.setImage(hand.getImage());
        hand.setIsAvailable(false);
        assetsRepository.save(assets);
        userEntity.getInventory().add(assets);
        userRepository.save(userEntity);
    }

    @Override
    public void buyHead(Long idHead, Long idUser) {
        AssetsEntity assets = new AssetsEntity();
        Head head = getHead(idHead);
        UserEntity userEntity = getUser(idUser);

        if (userEntity.getMoney() < head.getPrice()) {
            throw new NotFoundException("insufficient money");
        } else {
            userEntity.setMoney(userEntity.getMoney() - head.getPrice());
        }
        assets.setName(head.getName());
        assets.setImage(head.getImage());
        head.setIsAvailable(false);
        assetsRepository.save(assets);
        userEntity.getInventory().add(assets);
        userRepository.save(userEntity);
    }

    @Override
    public void buyLegs(Long idLegs, Long idUser) {
        AssetsEntity assets = new AssetsEntity();
        Legs legs = getLegs(idLegs);
        UserEntity userEntity = getUser(idUser);

        if (userEntity.getMoney() < legs.getPrice()) {
            throw new NotFoundException("insufficient money");
        } else {
            userEntity.setMoney(userEntity.getMoney() - legs.getPrice());
        }
        assets.setImage(legs.getImage());
        assets.setName(legs.getName());
        legs.setIsAvailable(false);
        assetsRepository.save(assets);
        userEntity.getInventory().add(assets);
        userRepository.save(userEntity);
    }

    @Override
    public void buyPets(Long idPets, Long idUser) {
        AssetsEntity assets = new AssetsEntity();
        Pet pet = getPet(idPets);
        UserEntity userEntity = getUser(idUser);

        if (userEntity.getMoney() < pet.getPrice()) {
            throw new NotFoundException("insufficient money");
        } else {
            userEntity.setMoney(userEntity.getMoney() - pet.getPrice());
        }
        assets.setName(pet.getName());
        assets.setImage(pet.getImage());
        pet.setIsAvailable(false);
        assetsRepository.save(assets);
        userEntity.getInventory().add(assets);
        userRepository.save(userEntity);

    }

    private BodyAssets getBody(Long id) {
        Optional<BodyAssets> body = bodyRepository.findById(id);
        if (body.isEmpty()) {
            throw new NotFoundException("Post not found.");
        }
        return body.get();
    }

    private UserEntity getUser(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new NotFoundException("Post not found.");
        }
        return user.get();
    }

    private Hair getHair(Long id) {
        Optional<Hair> hair = hairRepository.findById(id);
        if (hair.isEmpty()) {
            throw new NotFoundException("Post not found.");
        }
        return hair.get();
    }

    private Hand getHand(Long id) {
        Optional<Hand> hand = handRepository.findById(id);
        if (hand.isEmpty()) {
            throw new NotFoundException("Post not found.");
        }
        return hand.get();
    }

    private Head getHead(Long id) {
        Optional<Head> head = headRepository.findById(id);
        if (head.isEmpty()) {
            throw new NotFoundException("Post not found.");
        }
        return head.get();
    }

    private Legs getLegs(Long id) {
        Optional<Legs> legs = legsRepository.findById(id);
        if (legs.isEmpty()) {
            throw new NotFoundException("Post not found.");
        }
        return legs.get();
    }

    private Pet getPet(Long id) {
        Optional<Pet> pets = petsRepository.findById(id);
        if (pets.isEmpty()) {
            throw new NotFoundException("Post not found.");
        }
        return pets.get();
    }

}
