package com.union.interview.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import com.union.interview.domain.Status;


import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException ex) {
        var errors = ex.getBindingResult().getFieldErrors().stream()
                .map(e -> e.getField() + ": " + e.getDefaultMessage()).toList();
        return ResponseEntity.badRequest().body(Map.of("errors", errors));
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, Object>> handleBadBody(HttpMessageNotReadableException ex) {
        var cause = ex.getCause();
        if (cause instanceof InvalidFormatException ife) {
            var target = ife.getTargetType();
            if (target == Status.class) {
                return ResponseEntity.badRequest().body(
                    Map.of("errors", 
                        java.util.List.of("status: must be one of " + java.util.Arrays.toString(Status.values())))
                );
            }
        }
        return ResponseEntity.badRequest().body(Map.of("error", "Malformed JSON request"));
    }
    

}
