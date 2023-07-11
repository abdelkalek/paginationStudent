package com.example.paginationstudent.models.Dtos;
import lombok.Data;

import java.util.UUID;

/**
 * @author Abdelkhalek Guedri
 * @since 27/03/2023
 */
@Data
public class CreateStudentDto {
    private String firstname;
    private String lastname;
    private String cin;
    private String adress;
    private Integer age;
    private UUID universityuuid;
}
