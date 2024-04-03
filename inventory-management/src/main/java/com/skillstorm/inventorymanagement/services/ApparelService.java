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

  public List<Apparel> findAllInventory(){
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

  public Apparel updateApparel(Apparel currApparel, Apparel userInputApparel){
    currApparel.setSku(userInputApparel.getSku());
    currApparel.setCategory(userInputApparel.getCategory());
    currApparel.setSize(userInputApparel.getSize());
    currApparel.setLocation(userInputApparel.getLocation());
    currApparel.setWarehouse(userInputApparel.getWarehouse());
    return apparelRepository.save(currApparel);
  }


  public void deleteApparel(Apparel apparel){
    apparelRepository.delete(apparel);
  }

  public void deleteApparelById(int id){
    apparelRepository.deleteById(id);
  }
}
