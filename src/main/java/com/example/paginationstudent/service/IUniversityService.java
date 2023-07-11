package com.example.paginationstudent.service;
import com.example.paginationstudent.models.University;

import java.util.List;

/**
 * @author Abdelkhalek Guedri
 * @since 13/05/2023
 */
public interface IUniversityService extends ICrudService<University> {
    List<University> filter(String matricule , String name );

}
