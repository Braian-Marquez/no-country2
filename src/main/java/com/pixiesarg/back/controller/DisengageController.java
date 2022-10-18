package com.pixiesarg.back.controller;

import com.pixiesarg.back.service.DisengageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

@CrossOrigin(origins = "*", methods= {GET, POST, PUT, DELETE})
@RestController
@RequestMapping("disengage")
public class DisengageController {
    @Autowired
    private DisengageService disengageService;

    @PutMapping
    public ResponseEntity<Void> disengage(@RequestParam Long id)  {
        this.disengageService.disengage(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
