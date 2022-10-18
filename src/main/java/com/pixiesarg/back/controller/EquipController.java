package com.pixiesarg.back.controller;

import com.pixiesarg.back.service.EquipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

@CrossOrigin(origins = "*", methods= {GET, POST, PUT, DELETE})
@RestController
@RequestMapping("equip")
public class EquipController {
    @Autowired
    private EquipService equipService;


    @PutMapping
    public ResponseEntity<Void> buyBody(@RequestParam Long id,@RequestParam Long idAvatar)  {
        this.equipService.equip(id,idAvatar);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
