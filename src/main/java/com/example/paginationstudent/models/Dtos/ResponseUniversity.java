package com.example.paginationstudent.models.Dtos;

import lombok.Data;

import java.util.Date;

/**
 * @author Abdelkhalek Guedri
 * @since 13/05/2023
 */
@Data
public class ResponseUniversity {
    private String name;
    private String location;
    private String matricule;
    private Date dateCreation;
}
