package com.pixiesarg.back.controller;

import com.pixiesarg.back.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

@CrossOrigin(origins = "*", methods= {GET, POST, PUT, DELETE})
@RestController
@RequestMapping("inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;


    @PutMapping("body")
    public ResponseEntity<Void> buyBody(@RequestParam Long idBody,@RequestParam Long idUser)  {
        this.inventoryService.buyBody(idBody,idUser);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("hair")
    public ResponseEntity<Void> buyHair(@RequestParam Long idHair,@RequestParam Long idUser)  {
        this.inventoryService.buyHair(idHair,idUser);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("hand")
    public ResponseEntity<Void> buyHand(@RequestParam Long idHand,@RequestParam Long idUser)  {
        this.inventoryService.buyHand(idHand,idUser);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("head")
    public ResponseEntity<Void> buyHead(@RequestParam Long idHead,@RequestParam Long idUser)  {
        this.inventoryService.buyHead(idHead,idUser);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("legs")
    public ResponseEntity<Void> buyLegs(@RequestParam Long idLegs,@RequestParam Long idUser)  {
        this.inventoryService.buyLegs(idLegs,idUser);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("pets")
    public ResponseEntity<Void> buyPets(@RequestParam Long idPets,@RequestParam Long idUser)  {
        this.inventoryService.buyPets(idPets,idUser);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
