package com.skillstorm.inventorymanagement.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "APPAREL")
public class Apparel {

  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY) 
  private int id; 

  @Column
  private String sku;

  @Column
  private String category;

  @Column
  private String size;

  @Column
  private String location;

  @ManyToOne
  @JoinColumn(name= "warehouse_id")
  private Warehouse warehouse;
  
  public Apparel() {
  }


  public Apparel(int id, String sku, String category, String size, String location, Warehouse warehouse) {
    this.id = id;
    this.sku = sku;
    this.category = category;
    this.size = size;
    this.location = location;
    this.warehouse = warehouse;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Warehouse getWarehouse() {
    return warehouse;
  }

  public void setWarehouse(Warehouse warehouse) {
    this.warehouse = warehouse;
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    result = prime * result + ((sku == null) ? 0 : sku.hashCode());
    result = prime * result + ((category == null) ? 0 : category.hashCode());
    result = prime * result + ((size == null) ? 0 : size.hashCode());
    result = prime * result + ((location == null) ? 0 : location.hashCode());
    result = prime * result + ((warehouse == null) ? 0 : warehouse.hashCode());
    return result;
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Apparel other = (Apparel) obj;
    if (id != other.id)
      return false;
    if (sku == null) {
      if (other.sku != null)
        return false;
    } else if (!sku.equals(other.sku))
      return false;
    if (category == null) {
      if (other.category != null)
        return false;
    } else if (!category.equals(other.category))
      return false;
    if (size == null) {
      if (other.size != null)
        return false;
    } else if (!size.equals(other.size))
      return false;
    if (location == null) {
      if (other.location != null)
        return false;
    } else if (!location.equals(other.location))
      return false;
    if (warehouse == null) {
      if (other.warehouse != null)
        return false;
    } else if (!warehouse.equals(other.warehouse))
      return false;
    return true;
  }


  @Override
  public String toString() {
    return "Apparel [id=" + id + ", sku=" + sku + ", category=" + category + ", size=" + size + ", location=" + location
        + ", warehouse=" + warehouse + "]";
  }

  
  
  
}
