package com.pixiesarg.back.service.impl;

import com.pixiesarg.back.domain.assets.*;
import com.pixiesarg.back.domain.entity.StoreEntity;
import com.pixiesarg.back.domain.request.Request;
import com.pixiesarg.back.exception.NotFoundException;
import com.pixiesarg.back.mapper.AssetsMapper;
import com.pixiesarg.back.repository.*;
import com.pixiesarg.back.service.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AssetsServiceImpl implements AssetsService {
    private BodyRepository bodyRepository;
    private HairRepository hairRepository;
    private HandRepository handRepository;
    private HeadRepository headRepository;
    private LegsRepository legsRepository;
    private PetsRepository petsRepository;
    private AssetsMapper assetsMapper;
    private UploadFileService upload;
    private StoreRepository storeRepository;

    @Autowired
    public AssetsServiceImpl(BodyRepository bodyRepository, HairRepository hairRepository, HandRepository handRepository, HeadRepository headRepository, LegsRepository legsRepository, PetsRepository petsRepository, AssetsMapper assetsMapper, UploadFileService upload, StoreRepository storeRepository) {
        this.bodyRepository = bodyRepository;
        this.hairRepository = hairRepository;
        this.handRepository = handRepository;
        this.headRepository = headRepository;
        this.legsRepository = legsRepository;
        this.petsRepository = petsRepository;
        this.assetsMapper = assetsMapper;
        this.upload = upload;
        this.storeRepository = storeRepository;
    }

    @Override
    public Request createBody(String body, Long price, String photo) {
        BodyAssets bodyAssets = new BodyAssets();
        StoreEntity store = getStore(1L);
        bodyAssets.setName(body);
        bodyAssets.setImage(photo);
        bodyAssets.setPrice(price);
        this.bodyRepository.save(bodyAssets);
        store.getBody().add(bodyAssets);
        storeRepository.save(store);
        return assetsMapper.bodyToRequest(bodyAssets);
    }

    @Override
    public Request createHair(String hair, Long price, String photo) {
        Hair entity = new Hair();
        StoreEntity store = getStore(1L);
        entity.setName(hair);
        entity.setImage(photo);
        entity.setPrice(price);
        this.hairRepository.save(entity);
        store.getHair().add(entity);
        storeRepository.save(store);
        return assetsMapper.hairToRequest(entity);
    }

    @Override
    public Request createHand(String hand, Long price, String photo) {
        Hand entity = new Hand();
        StoreEntity store = getStore(1L);
        entity.setName(hand);
        entity.setImage(photo);
        entity.setPrice(price);
        this.handRepository.save(entity);
        store.getHand().add(entity);
        storeRepository.save(store);
        return assetsMapper.handToRequest(entity);
    }

    @Override
    public Request createHead(String head, Long price, String photo) {
        Head entity = new Head();
        StoreEntity store = getStore(1L);
        entity.setName(head);
        entity.setImage(photo);
        entity.setPrice(price);
        this.headRepository.save(entity);
        store.getHead().add(entity);
        storeRepository.save(store);
        return assetsMapper.headToRequest(entity);
    }

    @Override
    public Request createLegs(String legs, Long price, String photo) {
        Legs entity = new Legs();
        StoreEntity store = getStore(1L);
        entity.setName(legs);
        entity.setImage(photo);
        entity.setPrice(price);
        this.legsRepository.save(entity);
        store.getLegs().add(entity);
        storeRepository.save(store);
        return assetsMapper.legsToRequest(entity);
    }

    @Override
    public Request createPets(String pets, Long price, String photo) {
        Pet entity = new Pet();
        StoreEntity store = getStore(1L);
        entity.setName(pets);
        entity.setImage(photo);
        entity.setPrice(price);
        this.petsRepository.save(entity);
        store.getPets().add(entity);
        storeRepository.save(store);
        return assetsMapper.petsToRequest(entity);
    }

    private StoreEntity getStore(Long id) {
        Optional<StoreEntity> store = storeRepository.findById(id);
        if (store.isEmpty()) {
            throw new NotFoundException("Post not found.");
        }
        return store.get();
    }
}
