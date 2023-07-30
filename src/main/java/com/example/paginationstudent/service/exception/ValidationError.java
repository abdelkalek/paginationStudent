package com.example.paginationstudent.service.exception;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Abdelkhalek Guedri
 * @since 29/07/2023
 */
@Getter
@Setter
public class ValidationError {
    private String code;
    private String message;
}
