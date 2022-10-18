package com.pixiesarg.back.mapper;

import com.pixiesarg.back.domain.entity.AssetsEntity;
import com.pixiesarg.back.domain.request.Request;
import org.springframework.stereotype.Component;

@Component
public class InventoryMapper {
    public Request entityToRequest(AssetsEntity assets) {
        Request request = new Request();
        return request;
    }
}
