package com.example.paginationstudent.service.exception;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.Date;

/**
 * @author Abdelkhalek Guedri
 * @since 29/07/2023
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setTimeStamp(new Date().getTime());
        errorDetail.setStatus(status.value());
        errorDetail.setTitle("Message Not Readable");
        errorDetail.setDetail(ex.getMessage());
        errorDetail.setDeveloperMessage(ex.getClass().getName());
        return handleExceptionInternal(ex, errorDetail, headers, status, request);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException manve, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setTimeStamp(new Date().getTime());
        errorDetail.setStatus(status.value());
        errorDetail.setTitle("Message Not Valid");
        errorDetail.setDetail(manve.getMessage());
        errorDetail.setDeveloperMessage(manve.getClass().getName());
        return handleExceptionInternal(manve, errorDetail, headers, status, request);
    }

}