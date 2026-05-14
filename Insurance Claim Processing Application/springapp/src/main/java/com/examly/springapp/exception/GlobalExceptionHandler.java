package com.examly.springapp.exception;



import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;



import java.util.HashMap;

import java.util.Map;



@ControllerAdvice

public class GlobalExceptionHandler {



@ExceptionHandler(ResourceNotFoundException.class)

public ResponseEntity<Map<String, String>> handleResourceNotFoundException(ResourceNotFoundException ex) {

Map<String, String> error = new HashMap<>();

error.put("message", ex.getMessage());

return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

}



@ExceptionHandler(ValidationException.class)

public ResponseEntity<Map<String, String>> handleValidationException(ValidationException ex) {

Map<String, String> error = new HashMap<>();

error.put("message", ex.getMessage());

return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

}



@ExceptionHandler(MethodArgumentNotValidException.class)

public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
// String firstErrorMessage=ex.getBindingResult().getFieldErrors().isEmpty()
//     ?"Validation failed"
//     : ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
Map<String, String> error = new HashMap<>();


error.put("message","Validation failed");

return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

}

}