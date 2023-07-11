package com.example.paginationstudent.service;
import com.example.paginationstudent.models.Student;
import java.util.List;
import java.util.UUID;

/**
 * @author Abdelkhalek Guedri
 * @since 13/05/2023
 */
public interface IStudentService extends ICrudService<Student> {
   List<Student> filter(String cin , String firstname);
   List<Student> findStudentByUniversity(UUID universityUuid);
}
