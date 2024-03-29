package com.example.paginationstudent.service.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Abdelkhalek Guedri
 * @since 29/07/2023
 */
@Getter
@Setter
public class ErrorDetail {

    private String title;
    private int status;
    private String detail;
    private long timeStamp;
    private String path;
    private String developerMessage;
    private Map<String, List<ValidationError>> errors = new HashMap<String,
                List<ValidationError>>();
}
