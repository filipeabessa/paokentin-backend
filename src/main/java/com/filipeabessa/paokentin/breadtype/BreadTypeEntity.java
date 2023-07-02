package com.filipeabessa.paokentin.breadtype;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import static com.filipeabessa.paokentin.utils.Utils.generateRandomHexColor;
@Table(name = "bread_type")
@Entity
public class BreadTypeEntity {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "related_color")
    private final String relatedColor = generateRandomHexColor();
    @Column(name = "time_to_bake")
    private double timeToBake;
    @Column(name = "price_per_unit")
    private double pricePerUnit;
    @Column(name = "gluten_free")
    private boolean glutenFree;
    public BreadTypeEntity() {

    }
    public BreadTypeEntity(int id, String name, String description, double timeToBake, double pricePerUnit, boolean glutenFree) {
        this.id = id;
        this.name = name;
        this.timeToBake = timeToBake;
        this.pricePerUnit = pricePerUnit;
        this.description = description;
        this.glutenFree = glutenFree;
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
