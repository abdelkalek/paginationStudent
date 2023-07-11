package com.example.paginationstudent.service;
import com.example.paginationstudent.models.Student;
import com.example.paginationstudent.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Abdelkhalek Guedri
 * @since 27/03/2023
 */
@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentRepository studentRepo;

    @Override
    public List<Student> getAll() {
        return this.studentRepo.findAll();
    }

    @Override
    public Page<Student> getPage(Pageable p) {
        // Pageable pageable = PageRequest.of(0, 5, Sort.Direction.ASC, "id");
        Page<Student> validStudents = studentRepo.findAll(p);
        return validStudents;
    }

    @Override
    public Optional<Student> getById(UUID id) {
        Optional<Student> s = this.studentRepo.findById(id);
        return s;
    }

    @Override
    public Student AddOne(Student s) {
    return this.studentRepo.save(s);
    }

    @Override
    @Transactional
    public Student update(Student student) {
        return this.studentRepo.save(student);
    }

    @Override
    public void deleteById(UUID id) {
      this.studentRepo.deleteById(id);
    }

    @Override
    public List<Student> filter(String cin, String firstname) {
        return this.studentRepo.findAll().stream()
                        .filter(stu -> firstname == null || (stu.getFirstname().toLowerCase().contains(firstname.toLowerCase())))
                        .filter(stu -> cin == null || (stu.getCin().toLowerCase().contains(cin.toLowerCase())))
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> findStudentByUniversity(UUID universityUuid) {
        List<Student> studentList = this.studentRepo.findStudentByUniversity(universityUuid);
        return studentList;
    }
}
