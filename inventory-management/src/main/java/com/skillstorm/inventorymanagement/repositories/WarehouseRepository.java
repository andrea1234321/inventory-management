package com.skillstorm.inventorymanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.inventorymanagement.models.Warehouse;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer>{
  
}
