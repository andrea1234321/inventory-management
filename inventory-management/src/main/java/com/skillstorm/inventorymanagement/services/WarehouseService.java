package com.skillstorm.inventorymanagement.services;

import java.util.List;
import java.util.Optional;

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

  public Warehouse findById(int id){
    Optional<Warehouse> warehouse = warehouseRepository.findById(id);
    if(warehouse.isPresent()){
      return warehouse.get();
    }else{
      return null;
    }
  }

  public Warehouse updateWarehouse(Warehouse currWarehouse, Warehouse userInputWarehouse){
    currWarehouse.setCity(userInputWarehouse.getCity());
    currWarehouse.setState(userInputWarehouse.getState());
    currWarehouse.setCapacity(userInputWarehouse.getCapacity());
    return warehouseRepository.save(currWarehouse);
  }

  public void deleteWarehouse(Warehouse warehouse){
    warehouseRepository.delete(warehouse);
    //add functionality to delete all apparel with that id 
  }
  
  public void deleteWarehouseById(int id){
    warehouseRepository.deleteById(id);
    //add functionality to delete all apparel with that id 
  }
}
