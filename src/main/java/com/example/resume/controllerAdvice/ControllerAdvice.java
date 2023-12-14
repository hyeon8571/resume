package com.example.resume.controllerAdvice;

import com.example.resume.dto.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice {

    private void classifyErrors(Map<String, String> errors, FieldError error) {

        String field = error.getField();
        String message = error.getDefaultMessage();

        String existedMessage = errors.get(field);

        if (existedMessage != null) {
            message = existedMessage+","+message;
        }

        errors.put(field, message);
    }

    private List<ErrorDto> makeErrorResponse(Map<String, String> errors) {
        List<ErrorDto> errorResponse = new ArrayList<>();

        for (String field : errors.keySet()) {
            errorResponse.add(new ErrorDto(field, errors.get(field)));
        }

        log.info("errors: {}", errorResponse);

        return errorResponse;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorDto>> exceptionHandler(MethodArgumentNotValidException e) {

        Map<String, String> errorDtos = new HashMap<>();

        e.getBindingResult().getFieldErrors().forEach((fieldError) -> {
            classifyErrors(errorDtos, fieldError);
        });

        List<ErrorDto> errorResponse = makeErrorResponse(errorDtos);

        return ResponseEntity.badRequest().body(errorResponse);
    }

}
