package com.example.paginationstudent.controller;

import com.example.paginationstudent.models.Dtos.CreateStudentDto;
import com.example.paginationstudent.models.Dtos.CreateUniversityDto;
import com.example.paginationstudent.models.Dtos.ResponseUniversity;
import com.example.paginationstudent.models.Student;
import com.example.paginationstudent.models.University;
import com.example.paginationstudent.service.StudentServiceImpl;
import com.example.paginationstudent.service.UniversityServiceImpl;
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

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Abdelkhalek Guedri
 * @since 13/05/2023
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/university")
public class UniversityController {
    @Autowired
    private UniversityServiceImpl _universityService;
    Logger logger = LoggerFactory.getLogger(UniversityController.class);
    ModelMapper modelMapper = new ModelMapper();


    @GetMapping("/getall")
    public ResponseEntity<List<ResponseUniversity>> getall() {
        try{
            List<ResponseUniversity> responseUniversityList = _universityService.getAll().stream().map(element-> {
                return modelMapper.map(element, ResponseUniversity.class);
            }).collect(Collectors.toList());
            return ResponseEntity.ok().body(responseUniversityList);
        }
        catch (Exception e)
        {
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping("/getPage")
    public ResponseEntity getPage(@RequestParam int pageNo, @RequestParam int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.Direction.ASC, "name");
        Page<University> universityPage = _universityService.getPage(paging);
        return ResponseEntity.ok().body(universityPage);
    }

    @GetMapping("/getone/{id}")
    public ResponseEntity getOne(@PathVariable UUID id) {
        logger.info("An INFO Message {}", id.toString());
        return Optional
                .ofNullable(_universityService.findOne(id))
                .map(university -> ResponseEntity.ok().body(university))          //200 OK
                .orElseGet(() -> ResponseEntity.notFound().build());  //404 Not found
    }

    @PostMapping(value = {"/add"})
    public ResponseEntity addOne(@RequestBody CreateUniversityDto createuniversityDto) {
     try {
         CreateUniversityDto universityDto = createuniversityDto;
         ModelMapper modelMapper = new ModelMapper();
         University university = modelMapper.map(createuniversityDto, University.class);
         _universityService.AddOne(university);
         return ResponseEntity.status(HttpStatus.CREATED).build();
     }catch (Exception e)
     {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
     }

    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity update(@PathVariable UUID id, @RequestBody CreateUniversityDto createuniversityDto) {
        try {
            if (_universityService.findOne(id).isPresent()) {
                University university = modelMapper.map(createuniversityDto, University.class);
                return ResponseEntity.ok().body(_universityService.update(university));
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

    @GetMapping(value = "/getUniversity/{id}")
    public ResponseEntity<String> getUniversity(@PathVariable UUID id) {
        StringBuilder s = new StringBuilder();
        // Convert elements to strings and concatenate them, separated by commas
        String joined = _universityService.getAll().stream()
                .map(University::getName) // This will call student get  name
                .collect(Collectors.joining(", "));
        return ResponseEntity.ok().body(joined);
    }

    @GetMapping(value = "/filter/{matricule}/{name}")
    public ResponseEntity<List<CreateUniversityDto>> getUniversityFilter(@PathVariable String matricule, @PathVariable String name) {
        try {
            List<CreateUniversityDto> createUniversityDtos = _universityService.filter(matricule, name).stream().map(item -> {
                CreateUniversityDto universityDto = modelMapper.map(item, CreateUniversityDto.class);
                return universityDto;
            }).collect(Collectors.toList());
            return ResponseEntity.ok().body(createUniversityDtos);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}

