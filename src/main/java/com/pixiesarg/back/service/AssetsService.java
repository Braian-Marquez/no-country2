package com.pixiesarg.back.service;

import com.pixiesarg.back.domain.request.Request;
import org.springframework.web.multipart.MultipartFile;

public interface AssetsService {
    Request createBody(String body, Long price, String photo);

    Request createHair(String body, Long price, String photo);

    Request createHand(String body, Long price, String photo);

    Request createHead(String body, Long price, String photo);

    Request createLegs(String body, Long price, String photo);

    Request createPets(String body, Long price, String photo);
}
