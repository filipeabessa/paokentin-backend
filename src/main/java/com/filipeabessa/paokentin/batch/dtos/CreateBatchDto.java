package com.filipeabessa.paokentin.batch.dtos;

public class CreateBatchDto {
    private Long breadTypeId;
    private int quantity;

    public Long getBreadTypeId() {
        return breadTypeId;
    }

    public int getQuantity() {
        return quantity;
    }
}
