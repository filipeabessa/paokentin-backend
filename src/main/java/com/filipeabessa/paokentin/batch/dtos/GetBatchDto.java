package com.filipeabessa.paokentin.batch.dtos;

import com.filipeabessa.paokentin.breadtype.BreadTypeEntity;

import java.util.Date;

public class GetBatchDto {
    private long id;
    private int breadsQuantity;
    private String createdAt;
    private String finishAt;
    private String relatedColor;
    private BreadTypeEntity breadType;

    public long getId() {
        return id;
    }

    public int getBreadsQuantity() {
        return breadsQuantity;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBreadsQuantity(int breadsQuantity) {
        this.breadsQuantity = breadsQuantity;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setFinishAt(String finishAt) {
        this.finishAt = finishAt;
    }

    public BreadTypeEntity getBreadType() {
        return breadType;
    }

    public void setBreadType(BreadTypeEntity breadType) {
        this.breadType = breadType;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getFinishAt() {
        return finishAt;
    }

    public String getRelatedColor() {
        return relatedColor;
    }

    public void setRelatedColor(String relatedColor) {
        this.relatedColor = relatedColor;
    }
}
