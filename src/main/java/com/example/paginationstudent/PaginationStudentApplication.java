package com.example.paginationstudent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
public class PaginationStudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaginationStudentApplication.class, args);
    }

}
