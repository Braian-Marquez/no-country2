package com.pixiesarg.back.controller;

import com.pixiesarg.back.domain.response.StoreResponse;
import com.pixiesarg.back.repository.StoreRepository;
import com.pixiesarg.back.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;


@CrossOrigin(origins = "*", methods= {GET, POST, PUT, DELETE})
@RestController
@RequestMapping("store")
public class StoreController {
    @Autowired
    private StoreService storeService;
    @Autowired
    private StoreRepository storeRepository;

    @GetMapping("/{id}")
    public ResponseEntity<StoreResponse> getStore(@PathVariable Long id) {
        StoreResponse response = this.storeService.findById(id);
        return ResponseEntity.ok().body(response);
    }
}
