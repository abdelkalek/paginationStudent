package com.example.paginationstudent.service;

import com.example.paginationstudent.models.University;
import com.example.paginationstudent.repository.StudentRepository;
import com.example.paginationstudent.repository.UniversityRepository;
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
 * @since 13/05/2023
 */
@Service
public class UniversityServiceImpl implements IUniversityService {
    @Autowired
    private UniversityRepository _universityRepository;

    @Override
    public List<University> getAll() {
        return _universityRepository.findAll() ;
    }

    @Override
    public Page<University> getPage(Pageable pageable) {
        return _universityRepository.findAll(pageable);
    }

    @Override
    public Optional<University> findOne(UUID id) {
        Optional<University> university = _universityRepository.findById(id);
        return university;
    }

    @Override
    public University AddOne(University university) {
        return _universityRepository.save(university);
    }

    @Override
    @Transactional
    public University update(University university) {
        return _universityRepository.save(university);
    }

    @Override
    public void deleteById(UUID id) {
        _universityRepository.deleteById(id);
    }

    @Override
    public List<University> filter(String matricule, String name) {

        return _universityRepository.findAll().stream()
                .filter(stu -> name == null || (stu.getName().toLowerCase().contains(name.toLowerCase())))
                .filter(stu -> matricule == null || (stu.getMatricule().toLowerCase().contains(matricule.toLowerCase())))
                .collect(Collectors.toList());

    }
}
