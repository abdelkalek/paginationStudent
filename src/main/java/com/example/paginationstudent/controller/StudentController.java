package com.example.paginationstudent.controller;
import com.example.paginationstudent.models.Dtos.ResponseStudentDto;
import com.example.paginationstudent.models.Student;
import com.example.paginationstudent.models.Dtos.CreateStudentDto;
import com.example.paginationstudent.models.University;
import com.example.paginationstudent.repository.UniversityRepository;
import com.example.paginationstudent.service.StudentServiceImpl;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


/**
 * @author Abdelkhalek Guedri
 * @since 27/03/2023
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private UniversityRepository _universityRepository;

    Logger logger = LoggerFactory.getLogger(StudentController.class);
    ModelMapper modelMapper = new ModelMapper();


    @GetMapping("/getall")
    public ResponseEntity<List<ResponseStudentDto>> getall() {
        try {
            List<ResponseStudentDto> responseStudentDto = studentService.getAll().stream().map(element -> {
                return modelMapper.map(element, ResponseStudentDto.class);
            }).collect(Collectors.toList());
            return ResponseEntity.ok().body(responseStudentDto);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/getPage")
    public ResponseEntity getPage(@RequestParam int pageNo, @RequestParam int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.Direction.ASC, "firstname");
        Page<Student> sudentPage = this.studentService.getPage(paging);
        return ResponseEntity.ok().body(sudentPage);
    }

    @GetMapping("/getone/{id}")
    public ResponseEntity getOne(@PathVariable UUID id) {
        logger.info("An INFO Message {}", id.toString());
        return Optional
                .ofNullable(studentService.getById(id))
                .map(stu -> ResponseEntity.ok().body(stu))          //200 OK
                .orElseGet(() -> ResponseEntity.notFound().build());  //404 Not found
    }

    @PostMapping(value = {"/add"})
    public ResponseEntity addOne(@RequestBody CreateStudentDto s) throws SQLException {
        try {
            Optional<University> studentUniversity = _universityRepository.findById(s.getUniversityuuid());
            if (studentUniversity.isPresent()) {
                Student student = modelMapper.map(s, Student.class);
                student.setUniversity(studentUniversity.get());
                return ResponseEntity.status(HttpStatus.CREATED).build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }


    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity update(@PathVariable UUID id, @RequestBody CreateStudentDto s) {
        try {
            if (this.studentService.getById(id).isPresent()) {
                Student student = modelMapper.map(s, Student.class);
                return ResponseEntity.ok().body(this.studentService.update(student));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());

        }

    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable Long id) {
        return ResponseEntity.ok().body(id);
    }

    @GetMapping(value = "/getStudent/{id}")
    public ResponseEntity<String> getStudent(@PathVariable UUID id) {
        StringBuilder s = new StringBuilder();
        // Convert elements to strings and concatenate them, separated by commas
        String joined = this.studentService.getAll().stream()
                .map(Student::getFirstname) // This will call student get last name
                .collect(Collectors.joining(", "));
        return ResponseEntity.ok().body(joined);
    }

    @GetMapping(value = "/filter/{cin}/{firstname}")
    public ResponseEntity<List<CreateStudentDto>> getStudentFilter(@PathVariable String cin, @PathVariable String firstname) {
        try {
            List<CreateStudentDto> createStudentDtoList = this.studentService.filter(cin, firstname).stream().map(item -> {
                CreateStudentDto student = modelMapper.map(item, CreateStudentDto.class);
                return student;
            }).collect(Collectors.toList());
            return ResponseEntity.ok().body(createStudentDtoList);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }

    @GetMapping(value = "/findStudentByUniversity/{uuiduniversity}")
    public ResponseEntity<List<CreateStudentDto>> findStudentByUniversity(@PathVariable UUID uuiduniversity) {
        try {
            List<CreateStudentDto> createStudentDtoList = this.studentService.findStudentByUniversity(uuiduniversity).stream().map(element -> {
                return modelMapper.map(element, CreateStudentDto.class);
            }).collect(Collectors.toList());
            return ResponseEntity.ok().body(createStudentDtoList);
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }


}