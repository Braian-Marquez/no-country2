package com.pixiesarg.back.service.impl;

import com.pixiesarg.back.domain.entity.StoreEntity;
import com.pixiesarg.back.domain.response.StoreResponse;
import com.pixiesarg.back.exception.ParamNotFound;
import com.pixiesarg.back.mapper.StoreMapper;
import com.pixiesarg.back.repository.StoreRepository;
import com.pixiesarg.back.service.StoreService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private StoreMapper storeMapper;

    @Override
    public StoreResponse findById(Long id) {
        Optional<StoreEntity> entity=storeRepository.findById(id);
        if (entity.isEmpty()) {
            throw new ParamNotFound("Error: Invalid character id.");
        }

        return storeMapper.entityToResponse(entity.get());
    }

}
