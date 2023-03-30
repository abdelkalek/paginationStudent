package com.example.paginationstudent.service;

import com.example.paginationstudent.models.Student;
import com.example.paginationstudent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author Abdelkhalek Guedri
 * @since 27/03/2023
 */
@Service
public class StudentServiceImpl implements ICrudService<Student> {
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
    public Student getById(UUID id) {
        return null;
    }

    @Override
    public Student AddOne(Student s) {
        return this.studentRepo.save(s);
    }

    @Override
    public void update(UUID id, Student student) {
    }
    @Override
    public void deleteById(UUID id) {
    }
}
