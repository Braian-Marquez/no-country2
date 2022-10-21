package com.pixiesarg.back.service.impl;


import com.pixiesarg.back.domain.entity.UserEntity;
import com.pixiesarg.back.exception.NotFoundException;
import com.pixiesarg.back.repository.UserRepository;
import com.pixiesarg.back.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikesServiceImpl implements LikesService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void likes(Long idFavorite, Long idUser) {
        UserEntity myUser = getUserId(idUser);
        UserEntity favoriteUser = getUserId(idFavorite);


            if (favoriteUser.getLikes()>0){
                Long likes= favoriteUser.getLikes();
                favoriteUser.setLikes(likes+1L);
                myUser.getIdFavorite().add(idFavorite);
                Long money=myUser.getMoney();
                myUser.setMoney(money+100L);
                userRepository.save(myUser);
                userRepository.save(favoriteUser);
            }
            if (favoriteUser.getLikes().equals(null)){
                int likes= 0;
                favoriteUser.setLikes(likes+1L);
                myUser.getIdFavorite().add(idFavorite);
                Long money=myUser.getMoney();
                myUser.setMoney(money+100L);
                userRepository.save(myUser);
                userRepository.save(favoriteUser);
            }



    }

    private UserEntity getUserId(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new NotFoundException("Post not found.");
        }
        return user.get();
    }
}
