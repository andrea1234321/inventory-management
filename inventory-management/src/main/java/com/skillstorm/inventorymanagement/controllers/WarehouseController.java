package com.skillstorm.inventorymanagement.controllers;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.inventorymanagement.models.Warehouse;
import com.skillstorm.inventorymanagement.services.ApparelService;
import com.skillstorm.inventorymanagement.services.WarehouseService;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/warehouses")
@CrossOrigin("http://localhost:5173")
public class WarehouseController {
  
  @Autowired
  WarehouseService warehouseService;

  @Autowired
  ApparelService apparelService;

  @GetMapping
  public ResponseEntity<List<Warehouse>> findAllWarehouses() {
      List<Warehouse> warehouses = warehouseService.findAllWarehouses();
      return new ResponseEntity<List<Warehouse>>(warehouses, HttpStatus.OK);
  }
  //read
  @GetMapping("/{id}")
  public ResponseEntity<Warehouse> findWarehouseById(@PathVariable int id) {
      Warehouse warehouse = warehouseService.findById(id);
      return new ResponseEntity<Warehouse>(warehouse, HttpStatus.OK);
  }
  
  //create 
  @PostMapping
  public ResponseEntity<Warehouse> createWarehouse(@RequestBody Warehouse warehouse) {
      Warehouse newWarehouse = warehouseService.saveWarehouse(warehouse);
      return new ResponseEntity<Warehouse>(newWarehouse, HttpStatus.ACCEPTED);
  }
  //update
  @PutMapping("/{id}")
  public ResponseEntity<Warehouse> updateWarehouse(@RequestBody Warehouse userInputWarehouse, @PathVariable int id) {
      Warehouse currWarehouse = warehouseService.findById(id);
      Warehouse updatedWarehouse= warehouseService.updateWarehouse(currWarehouse, userInputWarehouse); 
      return new ResponseEntity<Warehouse>(updatedWarehouse, HttpStatus.ACCEPTED);
  }

  //delete
  @DeleteMapping
  public ResponseEntity<Warehouse> deleteWarehouse(@RequestBody Warehouse warehouse){
    warehouseService.deleteWarehouse(warehouse);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Warehouse> deleteWarehouseById(@PathVariable int id){
    apparelService.deleteApparelByWarehouseId(id);
    warehouseService.deleteWarehouseById(id);
    return ResponseEntity.noContent().build();
  }
}
