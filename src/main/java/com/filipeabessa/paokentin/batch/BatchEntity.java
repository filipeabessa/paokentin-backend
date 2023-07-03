package com.filipeabessa.paokentin.batch;

import com.filipeabessa.paokentin.breadtype.BreadTypeEntity;

import java.util.Date;

public class BatchEntity {
    private long id;
    private int breadsQuantity;
    private BreadTypeEntity breadType;
    private Date createdAt;
    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
