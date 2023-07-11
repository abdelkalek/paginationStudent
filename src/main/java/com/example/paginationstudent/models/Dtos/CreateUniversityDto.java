package com.example.paginationstudent.models.Dtos;

import com.example.paginationstudent.models.Abstracts.BaseEntity;
import com.example.paginationstudent.models.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Abdelkhalek Guedri
 * @since 13/05/2023
 */
@Data
public class CreateUniversityDto  {
    private String name;
    private String location;
    private String matricule;
    private Date dateCreation;

}
