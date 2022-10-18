package com.pixiesarg.back.controller;

import com.pixiesarg.back.domain.request.Request;
import com.pixiesarg.back.repository.AssetsRepository;
import com.pixiesarg.back.service.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

@CrossOrigin(origins = "*", methods= {GET, POST, PUT, DELETE})
@RestController
@RequestMapping("assets")
public class AssetsController {
    private AssetsRepository assetsRepository;
    private AssetsService assetsService;

    @Autowired
    public AssetsController(AssetsRepository assetsRepository, AssetsService assetsService) {
        this.assetsRepository = assetsRepository;
        this.assetsService = assetsService;
    }

    @PostMapping("body")
    public ResponseEntity<Request> saveBody(@RequestParam String body,@RequestParam Long price, @RequestParam String photo) {
        Request request = assetsService.createBody(body,price, photo);
        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }

    @PostMapping("hair")
    public ResponseEntity<Request> saveHair(@RequestParam String hair,@RequestParam Long price, @RequestParam String photo) {
        Request request = assetsService.createHair(hair,price, photo);
        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }

    @PostMapping("hand")
    public ResponseEntity<Request> saveHand(@RequestParam String hand,@RequestParam Long price,@RequestParam String photo) {
        Request request = assetsService.createHand(hand,price, photo);
        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }

    @PostMapping("head")
    public ResponseEntity<Request> saveHead(@RequestParam String hand,@RequestParam Long price, @RequestParam String photo) {
        Request request = assetsService.createHead(hand,price, photo);
        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }

    @PostMapping("legs")
    public ResponseEntity<Request> saveLegs(@RequestParam String legs,@RequestParam Long price, @RequestParam String photo) {
        Request request = assetsService.createLegs(legs,price, photo);
        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }

    @PostMapping("pets")
    public ResponseEntity<Request> savePets(@RequestParam String pets,@RequestParam Long price, @RequestParam String photo) {
        Request request = assetsService.createPets(pets,price, photo);
        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }
}
