package com.filipeabessa.paokentin.batch;

import com.filipeabessa.paokentin.breadtype.BreadTypeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "batch")
@Entity
public class BatchEntity {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;
    @Column(name = "breads_quantity")
    private int breadsQuantity;
    @ManyToOne
    @JoinColumn(name = "bread_type_id", nullable = false)
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
