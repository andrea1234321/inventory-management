package com.skillstorm.inventorymanagement.controllers;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.inventorymanagement.models.Warehouse;
import com.skillstorm.inventorymanagement.services.WarehouseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/warehouses")
public class WarehouseController {
  
  @Autowired
  WarehouseService warehouseService;

  @GetMapping
  public ResponseEntity<List<Warehouse>> findAllWarehouses() {
      List<Warehouse> warehouses = warehouseService.findAllWarehouses();
      return new ResponseEntity<List<Warehouse>>(warehouses, HttpStatus.OK);
  }
}
