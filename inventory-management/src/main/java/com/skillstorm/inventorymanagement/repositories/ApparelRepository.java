package com.skillstorm.inventorymanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.skillstorm.inventorymanagement.models.Apparel;

import jakarta.transaction.Transactional;

@Repository
public interface ApparelRepository extends JpaRepository<Apparel, Integer>{

  @Query("delete from Apparel a where a.warehouse.id = :warehouse_id")
  @Modifying
  @Transactional
  public void deleteByWarehouseId(@Param("warehouse_id") int id);
}
