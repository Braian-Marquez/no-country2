package com.pixiesarg.back.mapper;

import com.pixiesarg.back.domain.entity.StoreEntity;
import com.pixiesarg.back.domain.response.StoreResponse;
import org.springframework.stereotype.Component;


@Component
public class StoreMapper {

    public StoreResponse entityToResponse(StoreEntity entity) {
        StoreResponse storeResponse = new StoreResponse();
        storeResponse.setBody(entity.getBody());
        storeResponse.setHair(entity.getHair());
        storeResponse.setHand(entity.getHand());
        storeResponse.setHead(entity.getHead());
        storeResponse.setLegs(entity.getLegs());
        storeResponse.setPets(entity.getPets());
        return storeResponse;
    }
}
