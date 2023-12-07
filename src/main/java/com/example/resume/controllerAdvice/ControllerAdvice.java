package com.example.resume.controllerAdvice;

import com.example.resume.dto.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorDto>> exceptionHandler(MethodArgumentNotValidException e) {

        List<ErrorDto> errorDtos = new ArrayList<>();

        e.getBindingResult().getFieldErrors().forEach((fieldError) -> {
            errorDtos.add(jsonMapper(fieldError));
        });

        return ResponseEntity.badRequest().body(errorDtos);
    }

    private ErrorDto jsonMapper(FieldError error) {
        String field = error.getField();
        String message = error.getDefaultMessage();

        return ErrorDto.builder()
                .field(field)
                .message(message)
                .build();
    }
}
