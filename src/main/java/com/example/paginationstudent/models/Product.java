package com.example.paginationstudent.models;

import com.example.paginationstudent.models.Abstracts.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @author Abdelkhalek Guedri
 * @since 11/07/2023
 */
@Data
@Entity
@Table(name = "product")
public class Product extends BaseEntity {

    private String reference;
    private String nom;
    private  Integer qte;
    private Double prixUnit;

//Relation
}
