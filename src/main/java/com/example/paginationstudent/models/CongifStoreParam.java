package com.example.paginationstudent.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Abdelkhalek Guedri
 * @since 11/07/2023
 */
@Data
@Entity
@Table(name = "congifStoreParam")
public class CongifStoreParam {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    private String name;
    private String url;
    @OneToMany
    private List<CongifStoreProperties> congifStoreProperties;
}
