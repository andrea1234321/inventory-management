package com.skillstorm.inventorymanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.inventorymanagement.models.Apparel;
import com.skillstorm.inventorymanagement.services.ApparelService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/inventory")
@CrossOrigin("http://localhost:5173")
public class ApparelController {
  @Autowired
  ApparelService apparelService;


  @GetMapping
  public ResponseEntity<List<Apparel>> findAllInventory() {
    List<Apparel> apparels = apparelService.findAllInventory();
    return new ResponseEntity<List<Apparel>>(apparels, HttpStatus.OK);
  }

  //read
  @GetMapping("/{id}")
  public ResponseEntity<Apparel> findApparelById(@PathVariable int id) {
    Apparel apparel = apparelService.findById(id);
    return new ResponseEntity<Apparel>(apparel, HttpStatus.OK);
  }

  //create
  @PostMapping
  public ResponseEntity<Apparel> createApparel(@RequestBody Apparel apparel) {
    Apparel newApparel = apparelService.saveApparel(apparel);
    return new ResponseEntity<Apparel>(newApparel, HttpStatus.ACCEPTED);
  }

  //update
  @PutMapping("/{id}")
  public ResponseEntity<Apparel> updateApparel(@RequestBody Apparel userInputApparel, @PathVariable int id) {
      Apparel currApparel = apparelService.findById(id);
      Apparel updatedApparel= apparelService.updateApparel(currApparel, userInputApparel); 
      return new ResponseEntity<Apparel>(updatedApparel, HttpStatus.ACCEPTED);
  }

  //delete
  @DeleteMapping
  public ResponseEntity<Apparel> deleteApparel(@RequestBody Apparel apparel){
    apparelService.deleteApparel(apparel);
    return ResponseEntity.noContent().build();
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Apparel> deleteApparelById(@PathVariable int id){
    apparelService.deleteApparelById(id);
    return ResponseEntity.noContent().build();
  }
}
