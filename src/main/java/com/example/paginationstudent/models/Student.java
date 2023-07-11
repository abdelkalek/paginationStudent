package com.example.paginationstudent.models;

import com.example.paginationstudent.models.Abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.UUID;

/**
 * @author Abdelkhalek Guedri
 * @since 27/03/2023
 */

@Data
@Entity
@Table(name = "student")
public class Student extends BaseEntity {
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String cin;
    private String adress;
    private Integer age;
    @ManyToOne
    private University university;


}
