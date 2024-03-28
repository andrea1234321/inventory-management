package com.skillstorm.inventorymanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.inventorymanagement.models.Apparel;

@Repository
public interface ApparelRepository extends JpaRepository<Apparel, String>{

}
