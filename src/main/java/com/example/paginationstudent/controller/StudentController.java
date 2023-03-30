package com.example.paginationstudent.controller;
import com.example.paginationstudent.models.Student;
import com.example.paginationstudent.models.StudentDto;
import com.example.paginationstudent.service.StudentServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



/**
 * @author Abdelkhalek Guedri
 * @since 27/03/2023
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;
    @GetMapping("/getall")
    public ResponseEntity getall() {
        return ResponseEntity.ok().body(this.studentService.getAll());
    }
    @GetMapping("/getPage")
    public ResponseEntity getPage(@RequestParam  int pageNo , @RequestParam  int pageSize ) {

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.Direction.ASC, "firstname");
        Page<Student> sudentPage =  this.studentService.getPage(paging);
        return ResponseEntity.ok().body(sudentPage);
    }
    @PostMapping(value = {"/add"})
    public ResponseEntity addOne(@RequestBody  StudentDto s){
        StudentDto stdto = s;

       ModelMapper modelMapper = new ModelMapper();
        Student student = modelMapper.map(s,Student.class);
       return ResponseEntity.ok().body(this.studentService.AddOne(student));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable Long id) {
        return ResponseEntity.ok().body(id);    }
}
