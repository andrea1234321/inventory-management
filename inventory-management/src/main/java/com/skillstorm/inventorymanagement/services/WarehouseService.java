package com.skillstorm.inventorymanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.inventorymanagement.models.Warehouse;
import com.skillstorm.inventorymanagement.repositories.WarehouseRepository;

@Service
public class WarehouseService {
  
  @Autowired
  WarehouseRepository warehouseRepository;

  public List<Warehouse> findAllWarehouses(){
    return warehouseRepository.findAll();
  }

  public Warehouse saveWarehouse(Warehouse warehouse){
    return warehouseRepository.save(warehouse);
  }
}
