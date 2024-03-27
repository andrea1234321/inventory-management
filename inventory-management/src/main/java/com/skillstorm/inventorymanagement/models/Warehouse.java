package com.skillstorm.inventorymanagement.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name= "WAREHOUSE")
public class Warehouse {

  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id; 

  @Column
  private String city;

  @Column
  private String state;

  @Column
  private int capacity;

  @OneToMany(targetEntity = Apparel.class, mappedBy = "warehouse")
  private Set<Apparel> apparel;

  public Warehouse() {
  }

  public Warehouse(int id, String city, String state, int capacity) {
    this.id = id;
    this.city = city;
    this.state = state;
    this.capacity = capacity;
  }

  public Warehouse(int id, String city, String state, int capacity, Set<Apparel> apparel) {
    this.id = id;
    this.city = city;
    this.state = state;
    this.capacity = capacity;
    this.apparel = apparel;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public Set<Apparel> getApparel() {
    return apparel;
  }

  public void setApparel(Set<Apparel> apparel) {
    this.apparel = apparel;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    result = prime * result + ((city == null) ? 0 : city.hashCode());
    result = prime * result + ((state == null) ? 0 : state.hashCode());
    result = prime * result + capacity;
    result = prime * result + ((apparel == null) ? 0 : apparel.hashCode());
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
    Warehouse other = (Warehouse) obj;
    if (id != other.id)
      return false;
    if (city == null) {
      if (other.city != null)
        return false;
    } else if (!city.equals(other.city))
      return false;
    if (state == null) {
      if (other.state != null)
        return false;
    } else if (!state.equals(other.state))
      return false;
    if (capacity != other.capacity)
      return false;
    if (apparel == null) {
      if (other.apparel != null)
        return false;
    } else if (!apparel.equals(other.apparel))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Warehouse [id=" + id + ", city=" + city + ", state=" + state + ", capacity=" + capacity + ", apparel="
        + apparel + "]";
  }

}
