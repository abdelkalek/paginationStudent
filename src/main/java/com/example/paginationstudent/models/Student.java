package com.example.paginationstudent.models;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

/**
 * @author Abdelkhalek Guedri
 * @since 27/03/2023
 */

@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    public String firstname;
    public String lastname;
}
