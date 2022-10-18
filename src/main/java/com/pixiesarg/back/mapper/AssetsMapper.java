package com.pixiesarg.back.mapper;

import com.pixiesarg.back.domain.assets.*;
import com.pixiesarg.back.domain.request.Request;
import org.springframework.stereotype.Component;

@Component
public class AssetsMapper {

    public Request bodyToRequest(BodyAssets bodyAssets) {
        Request request = new Request();
        request.setName(bodyAssets.getName());
        request.setPrice(bodyAssets.getPrice());
        return request;
    }

    public Request hairToRequest(Hair hair) {
        Request request = new Request();
        request.setName(hair.getName());
        request.setPrice(hair.getPrice());
        return request;
    }

    public Request handToRequest(Hand entity) {
        Request request = new Request();
        request.setName(entity.getName());
        request.setPrice(entity.getPrice());
        return request;
    }

    public Request headToRequest(Head entity) {
        Request request = new Request();
        request.setName(entity.getName());
        request.setPrice(entity.getPrice());
        return request;
    }

    public Request legsToRequest(Legs entity) {
        Request request = new Request();
        request.setName(entity.getName());
        request.setPrice(entity.getPrice());
        return request;
    }

    public Request petsToRequest(Pet entity) {
        Request request = new Request();
        request.setName(entity.getName());
        request.setPrice(entity.getPrice());
        return request;
    }
}
