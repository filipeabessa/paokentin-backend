package com.filipeabessa.paokentin.batch;

import java.util.Date;

public class BatchEntity {
    private long id;
    private int breadsQuantity;
    private Long breadTypeId;
    private Date createdAt;

    private Date finishAt;
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

    public Long getBreadTypeId() {
        return breadTypeId;
    }

    public void setBreadTypeId(Long breadTypeId) {
        this.breadTypeId = breadTypeId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getFinishAt() {
        return finishAt;
    }

    public void setFinishAt(Date finishAt) {
        this.finishAt = finishAt;
    }
}
