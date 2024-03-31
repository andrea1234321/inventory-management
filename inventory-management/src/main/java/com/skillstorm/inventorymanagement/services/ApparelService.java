package com.skillstorm.inventorymanagement.services;

import java.util.List;
import java.util.Optional;

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

  public Apparel findById(int id){
    Optional<Apparel> apparel = apparelRepository.findById(id);
    if(apparel.isPresent()){
      return apparel.get();
    }else{
      return null;
    }
  }

  public Apparel saveApparel(Apparel apparel){
    return apparelRepository.save(apparel);
  }
}
