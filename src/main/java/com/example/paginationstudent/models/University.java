package com.example.paginationstudent.models;

import com.example.paginationstudent.models.Abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Abdelkhalek Guedri
 * @since 13/05/2023
 */
@Data
@Entity
@Table(name = "university")
public class University extends BaseEntity {
    private String name;
    private String location;
    @Column(unique = true)
    private String matricule;
    private Date dateCreation;
    @OneToMany
    private List<Student> studentList;

}
