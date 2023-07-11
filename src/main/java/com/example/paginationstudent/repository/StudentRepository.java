package com.example.paginationstudent.repository;
import com.example.paginationstudent.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.UUID;

/**
 * @author Abdelkhalek Guedri
 * @since 27/03/2023
 */
@Repository
public interface StudentRepository  extends JpaRepository<Student, UUID> {
 Page<Student> findAll(Pageable pageable);
 @Query(nativeQuery = true, value = "SELECT * FROM student  WHERE university_id  = ?1")
 List<Student> findStudentByUniversity(UUID universityuuid);
}
