package com.filipeabessa.paokentin.entities;

public class Batch {
  private int id;
  private int breadsQuantity;
  private BreadType breadType;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getBreadsQuantity() {
    return breadsQuantity;
  }

  public void setBreadsQuantity(int breadsQuantity) {
    this.breadsQuantity = breadsQuantity;
  }

  public BreadType getBreadType() {
    return breadType;
  }

  public void setBreadType(BreadType breadType) {
    this.breadType = breadType;
  }
}
