package com.skillstorm.inventorymanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.inventorymanagement.models.Apparel;
import com.skillstorm.inventorymanagement.repositories.ApparelRepository;


@Service
public class ApparelService {
  @Autowired
  ApparelRepository apparelRepository;

  public List<Apparel> findAllWarehouses(){
    return apparelRepository.findAll();
  }
}
