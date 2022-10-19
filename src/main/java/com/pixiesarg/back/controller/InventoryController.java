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
    public ResponseEntity<Void> buyBody(@RequestParam Long body,@RequestParam Long user,@RequestBody String example)  {
        this.inventoryService.buyBody(body,user);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("hair")
    public ResponseEntity<Void> buyHair(@RequestParam Long hair,@RequestParam Long user,@RequestBody String example)  {
        this.inventoryService.buyHair(hair,user);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("hand")
    public ResponseEntity<Void> buyHand(@RequestParam Long hand,@RequestParam Long user,@RequestBody String example)  {
        this.inventoryService.buyHand(hand,user);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("head")
    public ResponseEntity<Void> buyHead(@RequestParam Long head,@RequestParam Long user,@RequestBody String example)  {
        this.inventoryService.buyHead(head,user);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("legs")
    public ResponseEntity<Void> buyLegs(@RequestParam Long legs,@RequestParam Long user,@RequestBody String example)  {
        this.inventoryService.buyLegs(legs,user);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("pets")
    public ResponseEntity<Void> buyPets(@RequestParam Long pets,@RequestParam Long user,@RequestBody String example)  {
        this.inventoryService.buyPets(pets,user);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
