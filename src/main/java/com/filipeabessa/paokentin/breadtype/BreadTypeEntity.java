package com.filipeabessa.paokentin.breadtype;

import static com.filipeabessa.paokentin.utils.Utils.generateRandomHexColor;

public class BreadTypeEntity {
    private int id;
    private String name;
    private String description;
    private final String relatedColor;
    private double timeToBake;
    private double pricePerUnit;
    private boolean glutenFree;

    public BreadTypeEntity(int id, String name, String description, double timeToBake, double pricePerUnit, boolean glutenFree) {
        this.id = id;
        this.name = name;
        this.timeToBake = timeToBake;
        this.pricePerUnit = pricePerUnit;
        this.description = description;
        this.glutenFree = glutenFree;

        this.relatedColor = generateRandomHexColor();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public double getTimeToBake() {
        return timeToBake;
    }

    public void setTimeToBake(double timeToBake) {
        this.timeToBake = timeToBake;
    }
    public String getRelatedColor() {
        return relatedColor;
    }
}
