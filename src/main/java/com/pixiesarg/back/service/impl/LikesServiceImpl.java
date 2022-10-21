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
        UserEntity user = getUserId(idUser);
        UserEntity favorite = getUserId(idFavorite);

        if (user.getIdFavorite().stream().anyMatch(x -> x == idFavorite)) {
            throw new NotFoundException("Favorite included");
        } else {
            if (user.getLikes()==null){
                int likes= 0;
                favorite.setLikes(likes+1L);
                user.getIdFavorite().add(idFavorite);
                Long money=user.getMoney();
                user.setMoney(money+100L);
                userRepository.save(user);
                userRepository.save(favorite);
            }
            else if (user.getLikes()>0){
                Long likes= user.getLikes();
                favorite.setLikes(likes+1L);
                user.getIdFavorite().add(idFavorite);
                Long money=user.getMoney();
                user.setMoney(money+100L);
                userRepository.save(user);
                userRepository.save(favorite);
            }

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
