package com.skillstorm.inventorymanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.inventorymanagement.models.Apparel;
import com.skillstorm.inventorymanagement.services.ApparelService;

@RestController
@RequestMapping("/apparels")
public class ApparelController {
  @Autowired
  ApparelService apparelService;

  @GetMapping
  public ResponseEntity<List<Apparel>> findAllApparels() {
      List<Apparel> apparels = apparelService.findAllWarehouses();
      return new ResponseEntity<List<Apparel>>(apparels, HttpStatus.OK);
  }
}
