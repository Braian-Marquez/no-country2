package com.pixiesarg.back.controller;


import com.pixiesarg.back.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("likes")
public class LikesController {

    @Autowired
    private LikesService likesService;



    @PutMapping
    public ResponseEntity<Void> like(@RequestParam  Long idFavorite,@RequestParam   Long idUser) {
        this.likesService.likes(idFavorite, idUser);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
