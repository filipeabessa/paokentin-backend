package com.filipeabessa.paokentin.batch;

import com.filipeabessa.paokentin.breadtype.BreadTypeEntity;

public class BatchEntity {
    private int id;
    private int breadsQuantity;
    private BreadTypeEntity breadType;

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

    public BreadTypeEntity getBreadType() {
        return breadType;
    }

    public void setBreadType(BreadTypeEntity breadType) {
        this.breadType = breadType;
    }
}
