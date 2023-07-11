package com.example.paginationstudent.repository;

import com.example.paginationstudent.models.Student;
import com.example.paginationstudent.models.University;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author Abdelkhalek Guedri
 * @since 27/03/2023
 */
@Repository
public interface UniversityRepository extends JpaRepository<University, UUID> {
 Page<University> findAll(Pageable pageable);
}
