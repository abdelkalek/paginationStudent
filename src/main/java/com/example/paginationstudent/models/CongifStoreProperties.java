package com.example.paginationstudent.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

/**
 * @author Abdelkhalek Guedri
 * @since 11/07/2023
 */
@Data
@Entity
@Table(name = "congifStoreProperties")
public class CongifStoreProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    private String key;
    private String value;
}
