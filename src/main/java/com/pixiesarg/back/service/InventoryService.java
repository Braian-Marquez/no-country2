package com.pixiesarg.back.service;



public interface InventoryService {
    void buyBody(Long idBody, Long idUser);

    void buyHair(Long idHair, Long idUser);

    void buyHand(Long idHand, Long idUser);

    void buyHead(Long idHead, Long idUser);

    void buyLegs(Long idLegs, Long idUser);

    void buyPets(Long idPets, Long idUser);
}
